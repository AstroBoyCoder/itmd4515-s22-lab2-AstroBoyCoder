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
    private String title;
   
    @NotNull
    private int artistId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public Artist() {
    }

    public Artist(int artistId, String title) {
        this.title = title;
        this.artistId = artistId;
    }

    @Override
    public String toString() {
        return "Artist{" + " title=" + title + ", artistId=" + artistId + '}';
    }

}
