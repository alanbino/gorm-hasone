package gorm.hasone

import gorm.hasone.domain.AChild
import gorm.hasone.service.GormHasOneService
import io.micronaut.runtime.event.annotation.EventListener
import io.micronaut.runtime.server.event.ServerStartupEvent

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
public class Bootstrap {

    @Inject
    GormHasOneService gormHasOneService

    @EventListener
    void onApplicationEvent(ServerStartupEvent event) {
        saveData();
    }

    private void saveData() {
        gormHasOneService.save 'First Product Description', new AChild(description: 'First Child Description')
        gormHasOneService.save 'Second Product Description', new AChild(description: 'Second Child Description')
    }
}
