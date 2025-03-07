package com.awc20.spzx.manager.util;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spzx.auth")
@Component
public class UserAuthProperties {
    List<String> noAuthUrls;
}
