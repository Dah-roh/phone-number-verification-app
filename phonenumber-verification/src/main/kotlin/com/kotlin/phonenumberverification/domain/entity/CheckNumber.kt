package com.kotlin.phonenumberverification.domain.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


@Entity
class CheckNumber{
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null
    var phoneNumber: String = ""
}