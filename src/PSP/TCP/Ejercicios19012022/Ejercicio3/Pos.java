package PSP.TCP.Ejercicios19012022.Ejercicio3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Pos extends Thread {
    int elementos;
    int numPos;
    int puerto;
    int puertoAnterior;

    public Pos(int elementos, int numPos, int puerto, int puertoAnterior) {
        this.elementos = elementos;
        this.numPos = numPos;
        this.puerto = puerto;
        this.puertoAnterior = puertoAnterior;
    }

    @Override
    public void run() {
        try {
            if (numPos != 1) {
                System.out.println("Creamos un socket nuevo");
                InetSocketAddress addr = new InetSocketAddress("localhost", puertoAnterior);
                DatagramSocket socket = new DatagramSocket(addr);

                System.out.println("Soy " + numPos);

                byte[] mensaje = new byte[15];
                DatagramPacket datagramPacket = new DatagramPacket(mensaje, mensaje.length);
                socket.receive(datagramPacket);
                String mensajeReci = new String(datagramPacket.getData());
                System.out.println(mensajeReci.trim() + " en la posición " + numPos);

                InetAddress address = InetAddress.getByName("localhost");
                DatagramSocket datagramSocketRespuesta = new DatagramSocket();
                DatagramPacket datagramPacket1 = new DatagramPacket(mensajeReci.getBytes(), mensaje.length, address, puerto);
                datagramSocketRespuesta.send(datagramPacket1);

                socket.close();
                datagramSocketRespuesta.close();
                System.out.println("Acabado " + numPos);
            }else {
                String mensaje="token";
                InetAddress addr=InetAddress.getByName("localhost");
                DatagramSocket datagramSocket=new DatagramSocket();
                DatagramPacket datagramPacket=new DatagramPacket(mensaje.getBytes(StandardCharsets.UTF_8), mensaje.length(), addr, puerto);
                datagramSocket.send(datagramPacket);

                InetSocketAddress addr2=new InetSocketAddress("localhost", puerto);
                DatagramSocket datagramSocket1=new DatagramSocket(addr2);

                byte[] mensajero=new byte[15];
                DatagramPacket datagramPacket1=new DatagramPacket(mensajero, mensajero.length);
                datagramSocket1.receive(datagramPacket1);

                String mensajeReci=new String(datagramPacket1.getData());
                System.out.println(mensajeReci);

                datagramSocket.close();
                datagramSocket1.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class EjecutaPos {
    public static void main(String[] args) {
        int puerto = 6556;
        Scanner sc = new Scanner(System.in);
        System.out.print("Cuantos anillos quieres?: ");
        int elementos = sc.nextInt();
        for (int i = 1; i <= elementos; i++) {
            Pos pos = new Pos(elementos, i, puerto, puerto++);
            pos.start();
        }
    }
}