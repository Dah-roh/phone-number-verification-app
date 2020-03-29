package com.kotlin.phonenumberverification.web.controller

import com.kotlin.phonenumberverification.domain.entity.CheckNumber
import com.kotlin.phonenumberverification.usecase.phoneVerificationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam


@Controller
@RequestMapping(value = [""])
class PhoneNumberVerificationController {


    @Autowired
    lateinit var phoneVerificationService: phoneVerificationService

    @RequestMapping("")
    fun verification(): String {
        return "index"
    }

    @RequestMapping( "/verify")
    @ModelAttribute
    fun verifyPhoneNumber(@RequestParam phoneNumber: String, model : Model, checkNumber: CheckNumber, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            println("Error $bindingResult")
            return "index"
        }
        else if(!phoneVerificationService.verifyPhoneNumber(phoneNumber).contains("0")){
            return "verify"
        }
        return "index"
    }
}