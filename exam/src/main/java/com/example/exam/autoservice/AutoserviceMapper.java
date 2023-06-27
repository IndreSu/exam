package com.example.exam.autoservice;


public class AutoserviceMapper {

    public static Autoservice toAutoservice(AutoserviceDto autoserviceDto) {

        Autoservice autoservice = new Autoservice();
        autoservice.setTitle(autoserviceDto.getTitle());
        autoservice.setAddress(autoserviceDto.getAddress());
        autoservice.setOwner(autoserviceDto.getOwner());

        return autoservice;
    }

    public static AutoserviceDto toAutoserviceDto(Autoservice autosrvice){

        AutoserviceDto autoserviceDto = new AutoserviceDto();
        autoserviceDto.setTitle(autosrvice.getTitle());
        autoserviceDto.setAddress(autosrvice.getAddress());
        autoserviceDto.setOwner(autosrvice.getOwner());

        return autoserviceDto;
    }
}
