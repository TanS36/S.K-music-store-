package com.alatoo.example.myalatooapp.rest;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/music-store")
public class FunnyRestController {
    private final List<Song> songs = new ArrayList<>();

    @GetMapping("/songs")
    public List<Song> getSongs() {
        return songs;
    }

    @PostMapping("/add")
    public String addSong(@RequestBody Song song) {
        songs.add(song);
        return "Song added: " + song.getName();
    }

    @PutMapping("/edit/{index}")
    public String editSong(@PathVariable int index, @RequestBody Song updatedSong) {
        if (index >= 0 && index < songs.size()) {
            songs.set(index, updatedSong);
            return "Song at index " + index + " has been updated.";
        } else {
            return "Invalid index. Unable to edit song.";
        }
    }

    @DeleteMapping("/delete/{index}")
    public String deleteSong(@PathVariable int index) {
        if (index >= 0 && index < songs.size()) {
            Song removedSong = songs.remove(index);
            return "Deleted song: " + removedSong.getName();
        } else {
            return "Invalid index. Unable to delete song.";
        }
    }
}

public class Song {
    private String name;
    private String releaseDate;
    private double price;
    private String genre;
    private double duration;
    private String composer;
    private String performer;
    private String album;

    public Song() {
        "name": "Song 1",
        "releaseDate": "2024-01-01",
        "price": 2.99,
        "genre": "Pop",
        "duration": 3.5,
        "composer": "Composer Name",
        "performer": "Performer Name",
        "album": "Album Name"
    }

    public Song(String name, String releaseDate, double price, String genre, double duration, String composer, String performer, String album) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.price = price;
        this.genre = genre;
        this.duration = duration;
        this.composer = composer;
        this.performer = performer;
        this.album = album;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getReleaseDate() { return releaseDate; }
    public void setReleaseDate(String releaseDate) { this.releaseDate = releaseDate; }
    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }
    public double getDuration() { return duration; }
    public void setDuration(double duration) { this.duration = duration; }
    public String getComposer() { return composer; }
    public void setComposer(String composer) { this.composer = composer; }
    public String getPerformer() { return performer; }
    public void setPerformer(String performer) { this.performer = performer; }
    public String getAlbum() { return album; }
    public void setAlbum(String album) { this.album = album; }
}

class MusicStore {
    private List<Song> songList;

    public MusicStore() {
        this.songList = new ArrayList<>();
    }

    public void addSong(Song song) {
        songList.add(song);
        System.out.println("Song added: " + song.getName());
    }

    public void editSong(int index, Song updatedSong) {
        if (index >= 0 && index < songList.size()) {
            songList.set(index, updatedSong);
            System.out.println("Song at index " + index + " has been updated.");
        } else {
            System.out.println("Invalid index. Unable to edit song.");
        }
    }

    public void displaySongs() {
        if (songList.isEmpty()) {
            System.out.println("No songs in the store.");
        } else {
            for (int i = 0; i < songList.size(); i++) {
                System.out.println(i + ". " + songList.get(i));
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        MusicStore musicStore = new MusicStore();
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println("\nMusic Store Menu:");
            System.out.println("1. Add Song");
            System.out.println("2. Edit Song");
            System.out.println("3. Display Songs");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter release date: ");
                    String releaseDate = scanner.nextLine();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    double duration = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter composer: ");
                    String composer = scanner.nextLine();
                    System.out.print("Enter performer: ");
                    String performer = scanner.nextLine();
                    System.out.print("Enter album (or press Enter if none): ");
                    String album = scanner.nextLine();
                    if (album.isEmpty()) album = null;
                    
                    Song newSong = new Song(name, releaseDate, price, genre, duration, composer, performer, album);
                    musicStore.addSong(newSong);
                    break;
                case 2:
                    System.out.print("Enter the index of the song to edit: ");
                    int index = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Enter new details for the song:");
                    System.out.print("Enter song name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter release date: ");
                    releaseDate = scanner.nextLine();
                    System.out.print("Enter price: ");
                    price = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter genre: ");
                    genre = scanner.nextLine();
                    System.out.print("Enter duration (in minutes): ");
                    duration = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter composer: ");
                    composer = scanner.nextLine();
                    System.out.print("Enter performer: ");
                    performer = scanner.nextLine();
                    System.out.print("Enter album (or press Enter if none): ");
                    album = scanner.nextLine();
                    if (album.isEmpty()) album = null;
                    
                    Song updatedSong = new Song(name, releaseDate, price, genre, duration, composer, performer, album);
                    musicStore.editSong(index, updatedSong);
                    break;
                case 3:
                    musicStore.displaySongs();
                    break;
                case 4:
                    System.out.println("Exiting Music Store. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

