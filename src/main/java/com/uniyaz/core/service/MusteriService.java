package com.uniyaz.core.service;

import com.uniyaz.core.dao.MusteriDao;
import com.uniyaz.core.domain.Musteri;

import java.util.List;

public class MusteriService {

    MusteriDao musteriDao=new MusteriDao();

    public void saveMusteri(Musteri musteri) {
        validateSaveMusteri(musteri);
        musteriDao.saveMusteri(musteri);
    }

    private void validateSaveMusteri(Musteri musteri) {

        if (musteri.getAdi().matches(".*\\d.*")) throw new RuntimeException("Adi sayisal deger içeremez");
    }

    public List<Musteri> findAllHql() {
        return musteriDao.findAllHql();
    }
}
