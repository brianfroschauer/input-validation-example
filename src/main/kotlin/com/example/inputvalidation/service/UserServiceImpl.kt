package com.example.inputvalidation.service

import com.example.inputvalidation.entity.User
import com.example.inputvalidation.exception.NotFoundException
import com.example.inputvalidation.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserServiceImpl(private val repository: UserRepository) : UserService {

    override fun findOne(id: Long): User {
       return repository
               .findById(id)
               .orElseThrow { NotFoundException() }
    }

    override fun findAll(): List<User> = repository.findAll()

    override fun create(user: User): User = repository.save(user)

    override fun update(id: Long, user: User): User {
        return repository
                .findById(id)
                .map { old -> repository.save(old.copy(
                        firstName = user.firstName,
                        lastName = user.lastName,
                        age = user.age))
                }
                .orElseThrow { NotFoundException() }
    }

    override fun delete(id: Long) = repository.delete(findOne(id))
}
