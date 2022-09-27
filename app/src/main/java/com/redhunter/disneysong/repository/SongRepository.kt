package com.redhunter.disneysong.repository

import com.redhunter.disneysong.R
import com.redhunter.disneysong.model.SongData
import java.util.*

class SongRepository {
    private val allSong= listOf(
        SongData(R.raw.aladdin,"Aladdin",R.drawable.aladdin),
        SongData(R.raw.aladdin_2,"Aladdin",R.drawable.aladdin),
        SongData(R.raw.bambi,"Bambi",R.drawable.bambi),
        SongData(R.raw.bambi2,"Aladdin",R.drawable.bambi),
        SongData(R.raw.blanca_nieves,"Blanca nieves",R.drawable.blanca),
        SongData(R.raw.blanca_nieves_2,"Blanca nieves",R.drawable.blanca),
        SongData(R.raw.bolt,"Bolt",R.drawable.bolt),
        SongData(R.raw.blanca_nieves,"Blanca nieves",R.drawable.blanca),
        SongData(R.raw.blanca_nieves,"Blanca nieves",R.drawable.blanca),
        SongData(R.raw.chicken_little,"Chicken Little",R.drawable.chicken_little),
        SongData(R.raw.dalmatas,"101 Dalmatas",R.drawable.dalmatas),
        SongData(R.raw.dumbo,"Dumbo",R.drawable.dumbo),
        SongData(R.raw.el_jorobado_de_notredame,"El jorobado de notredame",R.drawable.el_jorobado),
        SongData(R.raw.el_libro_de_la_selva,"El libro de la selva",R.drawable.el_libro_de_la_selva),
        SongData(R.raw.el_libro_de_la_selva_2,"El libro de la selva",R.drawable.el_libro_de_la_selva),
        SongData(R.raw.el_planeta_del_tesoro,"El planeta del tesoro",R.drawable.el_planeta_del_tesoro),
        SongData(R.raw.el_rey_leon,"El rey leon",R.drawable.el_rey_leon),
        SongData(R.raw.el_rey_leon_2,"El rey leon",R.drawable.el_rey_leon),
        SongData(R.raw.frozen,"frozen",R.drawable.frozen),
        SongData(R.raw.frozen_2,"frozen",R.drawable.frozen),
        SongData(R.raw.frozen_4,"frozen",R.drawable.frozen),
        SongData(R.raw.hercules,"Hercules",R.drawable.hercules),
        SongData(R.raw.hercules_2,"Hercules",R.drawable.hercules),
        SongData(R.raw.la_bella_durmiente,"La bella durmiente",R.drawable.la_bella_durmiente),
        SongData(R.raw.la_bella_durmiente_2,"La bella durmiente",R.drawable.la_bella_durmiente),
        SongData(R.raw.la_bella_y_la_bestia,"La bella y la bestia",R.drawable.la_bella_y_la_bestia),
        SongData(R.raw.la_bella_y_la_bestia_2,"La bella y la bestia",R.drawable.la_bella_y_la_bestia),
        SongData(R.raw.la_dama_y_el_vagabundo,"La dama y el vagabundo",R.drawable.la_dama_y_el_vagabundo),
        SongData(R.raw.la_dama_y_el_vagabundo_2,"La dama y el vagabundo",R.drawable.la_dama_y_el_vagabundo),
        SongData(R.raw.la_princesa_y_el_sapo,"La princesa y el sapo",R.drawable.la_princesa_y_el_sapo),
        SongData(R.raw.la_princesa_y_el_sapo_2,"La princesa y el sapo",R.drawable.la_princesa_y_el_sapo),
        SongData(R.raw.la_sirenita,"La sirenita",R.drawable.la_sirenita),
        SongData(R.raw.la_sirenita_2,"La sirenita",R.drawable.la_sirenita),
        SongData(R.raw.las_locuras_del_emperador,"Las locuras del emperador",R.drawable.las_locuras_del_emperador),
        SongData(R.raw.lilo_y_stich,"Lilo y Stich",R.drawable.lilo_y_stich),
        SongData(R.raw.los_aristogatos,"Los aristogatos",R.drawable.los_aristogatos),
        SongData(R.raw.los_aristogatos_2,"Los aristogatos",R.drawable.los_aristogatos),
        SongData(R.raw.moana,"Moana",R.drawable.moana),
        SongData(R.raw.moana2,"Moana",R.drawable.moana),
        SongData(R.raw.mulan,"Mulan",R.drawable.mulan),
        SongData(R.raw.mulan_2,"Mulan",R.drawable.mulan),
        SongData(R.raw.ponocho,"pinocho",R.drawable.pinocho),
        SongData(R.raw.pinocho_2,"pinocho",R.drawable.pinocho),
        SongData(R.raw.pocahontas,"pocahontas",R.drawable.pocahontas),
        SongData(R.raw.pocahontas_2,"pocahontas",R.drawable.pocahontas),
        SongData(R.raw.ralph_el_demoledor,"ralph",R.drawable.ralph_el_demoledor),
        SongData(R.raw.ralph_2,"ralph",R.drawable.ralph_el_demoledor),
        SongData(R.raw.raya,"raya",R.drawable.raya),
        SongData(R.raw.robin_hood,"Robin hood",R.drawable.robin_hood),
        SongData(R.raw.robin_hood_2,"Robin hood",R.drawable.robin_hood),
        SongData(R.raw.tarza,"tarza",R.drawable.tarza),
        SongData(R.raw.tarza_2,"tarza",R.drawable.tarza),
        SongData(R.raw.tierra_de_osos,"Tierra de osos",R.drawable.tierra_de_osos),
        SongData(R.raw.tierra_de_osos_2,"Tierra de osos",R.drawable.tierra_de_osos),
        SongData(R.raw.vacas_vaqueras,"Vacas vaqueras",R.drawable.vacas_vaqueras),
    )

    private val check = mutableListOf<Int>()

    fun getRandomSong():SongData{
        val random = Random()
        var index = random.nextInt(53)
        while (check.contains(index)){
            index = random.nextInt(53)
        }
            check.add(index)
            return  allSong[index]
    }


}