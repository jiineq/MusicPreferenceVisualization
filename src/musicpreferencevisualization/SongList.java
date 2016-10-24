package musicpreferencevisualization;

public class SongList{
    
    public class Song {
        private String[] info = new String[4];
        private int[][][] count = new int[3][4][2];
        
        public Song(String str) {
            info[0] = str;
        }
        
        public String getString(SortBase base) {
            switch (base) {
            case Artist_Name:
                return info[1];
            case Song_Title:
                return info[0];
            case Genre:
                return info[2];
            case Year:
                return info[3];
            default:
                return info[0];
            }
        }
        
        public void setInfo(SortBase base, String str) {
            switch (base) {
            case Artist_Name:
                info[1] = str;
            case Song_Title:
                info[0] = str;
            case Genre:
                info[2] = str;
            case Year:
                info[3] = str;
            default:
                info[0] = str;
            }
        }
        public int compareTo(Song song) {
            return getString(GUI.sortBase).compareTo(
                song.getString(GUI.sortBase));
        }
    }
    
    private DLList<Song> list;
    
    private void fileReader() {
        
    }
}
