package com.kotlin.phonenumberverification.usecase

import com.kotlin.phonenumberverification.domain.entity.CheckNumber
import org.springframework.ui.Model
import org.springframework.web.servlet.ModelAndView

interface phoneVerificationService {
    fun verifyPhoneNumber(phoneNumber: String): String
}