package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AmericanSocket americanSocket = new AmericanSocket();
        Radio radio = new Radio();
        radio.playMusic(new SocketAdapter(americanSocket));
    }
}

class SocketAdapter implements IEuroSocket {
    AmericanSocket americanSocket;

    public SocketAdapter(AmericanSocket americanSocket) {
        this.americanSocket = americanSocket;
    }

    @Override
    public String getPower() {
        return this.americanSocket.getPower();
    }
}

interface Socket {
    String getPower();
}

interface IEuroSocket extends Socket {
}

interface IAmericanSocket extends Socket {
}

class AmericanSocket implements IAmericanSocket {
    @Override
    public String getPower() {
        return "110V";
    }
}

class Radio {
    void playMusic(IEuroSocket euroSocket) {
        System.out.println(euroSocket.getPower());
    }
}