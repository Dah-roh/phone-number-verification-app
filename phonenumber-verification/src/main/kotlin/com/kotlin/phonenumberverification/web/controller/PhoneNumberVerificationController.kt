package com.kotlin.phonenumberverification.web.controller

import com.kotlin.phonenumberverification.persistence.entity.CheckNumber
import com.kotlin.phonenumberverification.persistence.services.CheckNumberService
import com.kotlin.phonenumberverification.usecase.phoneVerificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping(value = [""])
class PhoneNumberVerificationController {


    @Autowired
    lateinit var phoneVerificationService: phoneVerificationService

    @Autowired
    lateinit var checkNumberService: CheckNumberService

    @RequestMapping("")
    fun verification(): String {
        return "index"
    }

    @RequestMapping( "/verify")
    fun verifyPhoneNumber(@RequestParam phoneNumber: String, @ModelAttribute("checkNumber") checkNumber: CheckNumber, model : Model, bindingResult: BindingResult): String {


        val result = phoneVerificationService.verifyPhoneNumber(phoneNumber)
        if (bindingResult.hasErrors()) {
            println("Error $bindingResult")
            return "index"
        } else if (result.contains('0')) {
            checkNumber.id=phoneNumber
            checkNumber.phoneNumber=result
            checkNumberService.save(checkNumber)
            return "verify"
        }
        return "redirect:/"
    }

    @RequestMapping(value = ["verify"], method = arrayOf(RequestMethod.GET))
    fun displayPhoneNumberInformation(@RequestParam phoneNumber: String, @ModelAttribute("checkNumber") checkNumber: CheckNumber):String{
        val checkNumber = checkNumberService.findById(phoneNumber)
        return "verify"
    }
}