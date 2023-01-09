package se.iths;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class App {

    public static final String SQL_SELECT_ALL_ARTIST = "SELECT ArtistId, AlbumId, Name, Title FROM Artist join Album USING (ArtistId) Order By ArtistId";

    static Map<Long,Artist> artists = new HashMap<>();

    public static void main(String[] args){

        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Chinook","iths", "iths");
            ResultSet rs = con.createStatement().executeQuery(SQL_SELECT_ALL_ARTIST);

            while(rs.next()) {
                long artistId = rs.getLong("ArtistId");
                String name = rs.getString("Name");


                long albumId = rs.getLong("AlbumId");
                String title = rs.getString("Title");

                Artist artist = new Artist(artistId, name);

                if(artists.containsKey(artistId)) {
                    artist = artists.get(artistId);
                }else {
                    artists.put(artist.getId(),artist);
                }
                Album album = new Album(albumId,title);
                artist.add(album);

            }
        } catch (SQLException e) {
            System.err.println("hej, något gick fel: " + e);
        }

        for(Artist artist : artists.values()) {
            System.out.println(artist);
        }






    }
}