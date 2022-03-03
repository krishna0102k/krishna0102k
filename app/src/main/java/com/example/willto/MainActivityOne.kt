package com.example.willto

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText

class MainActivityOne : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_1)
        val paymentMethodsCardNumberField =
            findViewById<AppCompatEditText>(R.id.payment_methods_card_number_field)
        val nameFields =
            findViewById<AppCompatEditText>(R.id.payment_methods_security_code_item)
        val cvvFields =
            findViewById<AppCompatEditText>(R.id.payment_methods_where_is_security_code)

        paymentMethodsCardNumberField.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //check if text length is not empty of a minimum of 5 characters
                if (s.isNotEmpty() && s.length > 5) {

                    //Case 1
                    //changes creditcard image
                    paymentMethodsCardNumberField
                        .setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_baseline_card_membership_24,
                            0,
                            0,
                            0
                        )


                    val cardNumber = paymentMethodsCardNumberField.text.toString()
                    if (cardNumber.subSequence(0, 6) == "610301"
                        || cardNumber.subSequence(0, 6) == "610281"
                        || cardNumber.subSequence(0, 6) == "636301"
                    ) {
                        //Case 2
                        //Hides two fields
                        nameFields.visibility = View.GONE
                        cvvFields.visibility = View.GONE

                    } else if (cardNumber.subSequence(0, 6) == "414364") {
                        // case 3
                        //Hides one fields
                        nameFields.visibility = View.GONE
                    }

                } else {
                    paymentMethodsCardNumberField
                        .setCompoundDrawablesWithIntrinsicBounds(
                            R.drawable.ic_baseline_credit_card_24,
                            0,
                            0,
                            0
                        )
                    nameFields.visibility = View.VISIBLE
                    cvvFields.visibility = View.VISIBLE
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }
}