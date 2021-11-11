import java.util.*;

public class MusicExchangeCenter {
    private ArrayList<User> users;
    private HashMap<String, Float> royalties;
    private ArrayList<Song> downloadedSongs;

    public MusicExchangeCenter(){
        users = new ArrayList();
        royalties = new HashMap<>();
        downloadedSongs = new ArrayList<>();
    }

    public ArrayList<User> onlineUsers(){
        ArrayList<User> onlineUserList = new ArrayList();
        for(User u: users){
            if(u.isOnline()){
                onlineUserList.add(u);
            }
        }
        return onlineUserList;
    }

    public ArrayList<Song> allAvailableSongs() {
        ArrayList<Song> availableSongsList = new ArrayList();
        ArrayList<User> temp = onlineUsers();
        for(User t: temp){
            availableSongsList.addAll(t.getSongList());
        }
        return availableSongsList;
    }

    public User userWithName(String s){
        for(User u: users){
            if(s.equals(u.getUserName())){
                return u;
            }
        }
        return null;
    }

    public void registerUser(User x){
        if(userWithName(x.getUserName()) == null){
            users.add(x);
        }
    }

    public ArrayList<Song> availableSongsByArtist(String artist){
        ArrayList<Song> songsByArtistList = new ArrayList();
        for(Song s: allAvailableSongs()){
            if(s.getArtist().equals(artist)){
                songsByArtistList.add(s);
            }
        }
        return songsByArtistList;
    }

    public Song getSong(String title, String ownerName) {
        ArrayList<User> usersOnline = onlineUsers();
        for (User user : usersOnline) {
            if (user.getUserName().equals(ownerName)) {
                Song temp = user.songWithTitle(title);
                if (temp != null) {
                    downloadedSongs.add(temp);
                    if (royalties.containsKey(temp.getArtist())) {
                        royalties.replace(temp.getArtist(), royalties.get(temp.getArtist()) + (float) (0.25));
                    } else {
                        royalties.put(temp.getArtist(), (float) (0.25));
                    }
                    return temp;
                }
            }
        }
        return null;
    }

    public void displayRoyalties(){


        System.out.println(String.format("%-10s", "Amount") + String.format("%-10s", "Artist"));
        System.out.println("--------------------");
        for(String s: royalties.keySet()){
            System.out.println("$" + String.format("%-9s", String.format("%1.2f", royalties.get(s))) + String.format("%-10s", s));
        }
    }

    private HashMap<Song, Integer> countDownloads(){
        HashMap<Song, Integer> downloads = new HashMap<>();
        TreeSet<Song> uniqueDownloads = uniqueDownloads();

        for(Song song: uniqueDownloads){
            int i = 0;
            for(Song temp: downloadedSongs){
                if(temp.getTitle().equals(song.getTitle())){
                    i++;
                }
            }
            downloads.put(song, i);
        }
        return downloads;
    }

    public TreeSet<Song> uniqueDownloads(){
        TreeSet<Song> uniqueList = new TreeSet<>(downloadedSongs);
        return uniqueList;
    }

    public ArrayList<Pair<Integer, Song>> songsByPopularity(){
        ArrayList<Pair<Integer, Song>> popularSongPairs = new ArrayList<>();
        HashMap<Song, Integer> downloadCount = countDownloads();

        for(Song song: countDownloads().keySet()){
            popularSongPairs.add(new Pair<Integer, Song> (downloadCount.get(song), song));
        }

        Collections.sort(popularSongPairs, new Comparator<Pair<Integer, Song>>() {
            public int compare(Pair<Integer, Song> p1, Pair<Integer, Song> p2) {
                return p2.getKey().compareTo(p1.getKey());
            }
        });
        return popularSongPairs;
    }

    public String toString(){
        return("Music Exchange Center (" + onlineUsers().size() + " users online, " + allAvailableSongs().size() + " songs available)");
    }

    public ArrayList<Song> getDownloadedSongs() {
        return downloadedSongs;
    }
}
