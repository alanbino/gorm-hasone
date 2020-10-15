package gorm.hasone.service

import gorm.hasone.domain.AChild
import gorm.hasone.domain.AParent
import grails.gorm.services.Service

@Service(AParent)
interface GormHasOneService {
    AParent save(String parentDescription, AChild aChild)
    List<AParent> list()
}
