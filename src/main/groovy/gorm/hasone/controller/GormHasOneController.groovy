package gorm.hasone.controller

import gorm.hasone.service.GormHasOneService
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

import javax.inject.Inject

@Controller("/")
class GormHasOneController {

    @Inject
    GormHasOneService gormHasOneService

    @Get("/triggerHasOne")
    boolean triggerHasOne() {
        gormHasOneService.triggerHasOne()
        return true
    }
}
