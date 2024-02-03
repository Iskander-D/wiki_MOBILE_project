package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:local.properties"
})

public interface LocalConfig extends Config {

    @Key("device")
    String getDevice();

    @Key("os_version")
    String getVersion();

}
