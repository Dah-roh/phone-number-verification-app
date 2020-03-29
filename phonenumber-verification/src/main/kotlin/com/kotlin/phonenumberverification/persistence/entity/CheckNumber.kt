package com.kotlin.phonenumberverification.persistence.entity

import javax.persistence.Entity
import javax.persistence.Id


@Entity
class CheckNumber{
    @Id
    var id: String = ""
    var phoneNumber: String = ""
}