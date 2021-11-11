import java.util.ArrayList;

public class User {
  private String     userName;
  private boolean    online;
  private ArrayList<Song> songList;
  
  public User()  { this(""); }
  
  public User(String u)  {
    userName = u;
    online = false;
    songList = new ArrayList();
  }
  
  public String getUserName() { return userName; }
  public boolean isOnline() { return online; }

  public ArrayList getSongList() {
    return songList;
  }

  public void addSong(Song song){
    if(!songList.contains(song)){
      if(song.getOwner() == null){
        song.setOwner(this);
        songList.add(song);
      }
      else{
        Song temp = new Song(song.getTitle(), song.getArtist(), song.getMinutes(), song.getSeconds());
        temp.setOwner(this);
        songList.add(temp);
      }
    }
  }

  public int totalSongTime(){
    if(songList.size() != 0) {
      int temp = 0;
      for (int i = 0; i < songList.size(); i++) {
        temp += songList.get(i).getDuration();
      }
      return temp;
    }
    else{
      return 0;
    }
  }

  public void register(MusicExchangeCenter m){
    m.registerUser(this);
  }

  public ArrayList<String> requestCompleteSonglist(MusicExchangeCenter m){
    ArrayList<Song> songsList = m.allAvailableSongs();
    ArrayList<String> songNamesList = new ArrayList();
    songNamesList.add(String.format("%-30s", "TITLE") + String.format("%-20s", "ARTIST") + String.format("%-6s", "TIME") + "  " + String.format("%-15s", "OWNER"));
    songNamesList.add(String.format("%-75s", ""));
    for(int i = 0; i < songsList.size(); i++){
      songNamesList.add(String.format("%-30s", i+1 + ". " + songsList.get(i).getTitle()) + String.format("%-20s", songsList.get(i).getArtist()) +songsList.get(i).getMinutes() +":" + String.format("%02d", songsList.get(i).getSeconds()) + "    " + String.format("%-15s", songsList.get(i).getOwner().getUserName()));
    }
    return songNamesList;
  }

  public ArrayList<String> requestSonglistByArtist(MusicExchangeCenter m, String artist){
    ArrayList<Song> songsList = m.availableSongsByArtist(artist);
    ArrayList<String> songListByArtist = new ArrayList();
    songListByArtist.add(String.format("%-30s", "TITLE") + String.format("%-20s", "ARTIST") + String.format("%-6s", "TIME") + "  " + String.format("%-15s", "OWNER"));
    songListByArtist.add(String.format("%-75s", ""));
    for(int i = 0; i < songsList.size(); i++){
      songListByArtist.add(String.format("%-30s", i+1 + ". " + songsList.get(i).getTitle()) + String.format("%-20s", songsList.get(i).getArtist()) +songsList.get(i).getMinutes() +":" + String.format("%02d", songsList.get(i).getSeconds()) + "    " + String.format("%-15s", songsList.get(i).getOwner().getUserName()));
    }
    return songListByArtist;
  }

  public void downloadSong(MusicExchangeCenter m, String title, String ownerName){
    Song temp = m.getSong(title, ownerName);
    if(temp != null && !songList.contains(temp))
    {
      addSong(temp);
    }
  }

  public void logon(){
    online = true;
  }

  public void logoff(){
    online = false;
  }

  public Song songWithTitle(String title){
    for (Song song : songList) {
      if (song.getTitle().equals(title)) {
        return song;
      }
    }
    return null;
  }
  
  public String toString()  {
    String s = "" + userName + ": " + songList.size() + " songs (";
    if (!online) s += "not ";
    return s + "online)";
  }
}
