package musicpreferencevisualization;

import java.util.*;
import CS2114.Button;

public class GUI implements Observer {

    public static SortBase sortBase = SortBase.Artist_Name;
    private RepresentBase repreBase = RepresentBase.Hobby;
    private Button sortArtist;
    private Button sortTitle;
    private Button sortYear;
    private Button sortGenre;
    
    private Button repreHobby;
    private Button repreMajor;
    private Button repreRegion;
    
    public GUI() {
        sortArtist = new Button("Sort by Artist Name");
        sortTitle = new Button("Sort by Song Title");
        sortYear = new Button("Sort by Release Year");
        sortGenre = new Button("Sort by Genre");
        repreHobby = new Button("Represent Hobby");
        repreMajor = new Button("Represent Major");
        repreRegion = new Button("Represent Region");
    }
    @Override
    public void update(Observable arg0, Object arg1) {
        // TODO Auto-generated method stub
        
    }
    
    public void clickedSort(Button button) {
        switch (button.getTitle()) {
        case("Sort by Artist Name"):
            sortBase = SortBase.Artist_Name;
        case("Sort by Song Title"):
            sortBase = SortBase.Song_Title;
        case("Sort by Release Year"):
            sortBase = SortBase.Year;
        case("Sort by Genre"):
            sortBase = SortBase.Genre;
        default:
            sortBase = SortBase.Artist_Name;
        }
        //TODO sort
        //TODO display
    }
    
    public void clickedRepresent(Button button) {
        switch (button.getTitle()) {
        case("Represent Hobby"):
            repreBase = RepresentBase.Hobby;
        case("Represent Major"):
            repreBase = RepresentBase.Major;
        case("Represent Region"):
            repreBase = RepresentBase.Region;
        default:
            repreBase = RepresentBase.Hobby;
        }
        //TODO get
        //TODO display
    }
}
