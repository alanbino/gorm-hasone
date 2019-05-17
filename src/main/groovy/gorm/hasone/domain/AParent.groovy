package gorm.hasone.domain

import grails.gorm.annotation.Entity

@Entity
class AParent {

    static mapping = {
        table 'a_parent'
        id generator:'assigned'
        aChild fetch: 'lazy', lazy: true
    }

    String id

    String parentDescription

    static hasOne = [aChild:AChild]

}
