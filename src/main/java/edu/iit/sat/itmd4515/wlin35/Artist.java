/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.wlin35;

import javax.validation.constraints.NotNull;

/**
 *
 * @author wlin35
 */
public class Artist {
    
    @NotNull
    private String name;
   
    @NotNull
    private Integer artistId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public Artist() {
    }

    public Artist(Integer artistId, String name) {
        this.name = name;
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Artist{" + " name=" + name + ", artistId=" + artistId + '}';
    }

}
