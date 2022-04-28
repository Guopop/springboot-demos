package me.guopop.think.in.spring.ioc.overview.domain;

import me.guopop.think.in.spring.ioc.overview.anno.Super;

/**
 * @author guopop
 * @date 2021/11/5 23:11
 */
@Super
public class SuperUser extends User {
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
