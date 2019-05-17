package gorm.hasone.domain

import grails.gorm.annotation.Entity

@Entity
class AChild {

    static mapping = {
        table 'a_child'
        id generator:'assigned'
    }

    String id

    String description

    static belongsTo = [parent:AParent]

}
