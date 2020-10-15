package gorm.hasone.domain

import grails.gorm.annotation.Entity

@Entity
class AChild {
    String description

    static belongsTo = [parent:AParent]
}
