package com.ohashi.contentmanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ContentManagementApplication

fun main(args: Array<String>) {
	runApplication<ContentManagementApplication>(*args)
}
