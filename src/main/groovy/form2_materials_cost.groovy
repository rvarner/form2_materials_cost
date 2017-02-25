/**
 * Created by reid on 2/24/17.
 */

import geb.Browser

// Get the user / pass from Last Pass
// NOTE: If NOT using LastPass: Comment this out and set user/pass variables manually
p = "lpass show formlabs.com".execute()
lines = p.text.readLines()
user = lines[1].split(/:\s/)[1]
pass = lines[2].split(/:\s/)[1]
p.waitFor()

// Uncomment and fill with username (usually email) and password
//user = ''
//pass = ''

prices = [
        durable    : 175.0,
        clear      : 149.0,
        white      : 149.0,
        grey       : 149.0,
        black      : 149.0,
        flexible   : 199.0,
        tough      : 175.0,
        'high temp': 199.0,
        castable   : 299.0,
        dental     : 399.0
]

/**
 * Simple rounding function
 * @param value
 * @param precision
 * @return
 */
double round(value, int precision) {
    int scale = (int) Math.pow(10, precision);
    return (double) Math.round(value * scale) / scale;
}

// Launch the browser
Browser.drive {

    // Go to the login page
    go "https://formlabs.com/dashboard/"
    waitFor {
        title == 'Dashboard – Formlabs'
    }
    // Fill in the forms
    $('input', name: 'username') << user
    $('input#passwd_field') << pass

    // Click login
    $('div.js-submit.button.expand').click()
    sleep(2000)
    go 'https://formlabs.com/dashboard/#prints'
    sleep(2000)

    def prints = $('div#prints-list div.print-item')
    println "Found ${prints.size()} prints"
    prints.each { p ->
        p.click()
        sleep(700)
        // Get the type
        def type = p.find('div.print-item__material span.material-badge').text().trim().toLowerCase()
        println "Type: $type"

        // Get the mL
        def ml = $('div.prints__print-detail.hide-for-small-only div.s-caption').find {
            it.text().contains('mL')
        }.text().split(/\s/)[0].trim()
        println "ML: Size: $ml\n"
        ml = Float.parseFloat(ml)

        // Calc the price
        def price = (ml / 1000.0) * prices[type]
        price = round(price, 2)

        // Generate a note
        def costStr = """Materials: \$${String.format("%.2f", price)}"""
        println costStr

        def textarea = $('div.prints__print-detail.hide-for-small-only textarea.c-print-notes')
        if (!textarea.text().trim().contains('Materials:')) {
            if (!textarea.text().trim().isEmpty()) {
                textarea << '\n'
            }
            textarea << costStr
            println "Filling \"$costStr\""
        } else {
            println "Not filling \"$costStr\""
        }
        sleep(500)
    }
    prints[0].click()
}