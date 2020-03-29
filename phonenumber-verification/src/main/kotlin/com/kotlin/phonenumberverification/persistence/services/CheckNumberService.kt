package com.kotlin.phonenumberverification.persistence.services

import com.kotlin.phonenumberverification.persistence.entity.CheckNumber

interface CheckNumberService {
        fun save(checkNumber: CheckNumber)
        fun findById(id: String):CheckNumber
    }