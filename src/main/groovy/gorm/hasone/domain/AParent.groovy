package gorm.hasone.domain

import grails.gorm.annotation.Entity

@Entity
class AParent {

    static mapping = {
        aChild fetch: 'join'
    }

    String parentDescription

    static hasOne = [aChild:AChild]

}
