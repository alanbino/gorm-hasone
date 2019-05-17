package gorm.hasone.service

import gorm.hasone.domain.AParent
import grails.gorm.transactions.Transactional

import javax.inject.Singleton

@Singleton
class GormHasOneService {

    @Transactional
    void triggerHasOne() {
        List<String> ids = [
                "1000",
                "1001",
                "1002",
                "1003",
                "1004",
                "1005",
                "1006",
                "1007",
                "1008",
                "1009"
        ]
        AParent.findAllByIdInList(ids)
        // check console out hibernate prints
    }
}
