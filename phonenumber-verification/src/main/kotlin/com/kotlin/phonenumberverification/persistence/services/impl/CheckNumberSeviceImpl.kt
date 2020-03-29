package com.kotlin.phonenumberverification.persistence.services.impl

import com.kotlin.phonenumberverification.persistence.entity.CheckNumber
import com.kotlin.phonenumberverification.persistence.services.CheckNumberService
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service

@Service
class CheckNumberSeviceImpl (private val repository: CheckNumberRepository): CheckNumberService{
    override fun save(checkNumber: CheckNumber) {
        repository.save(checkNumber)
    }
    override fun findById(id: String): CheckNumber {
        return repository.findById(id)
    }
}



interface CheckNumberRepository: CrudRepository<CheckNumber, Long> {
    fun findById(id: String):CheckNumber
}