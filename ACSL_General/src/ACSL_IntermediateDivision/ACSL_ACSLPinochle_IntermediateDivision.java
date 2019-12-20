package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ACSL_ACSLPinochle_IntermediateDivision {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("Pinochle1.txt");
		Scanner scan = new Scanner(file);

		for (int i = 0; i < 5; i++) {
			int points = 0;
			String[] in = scan.nextLine().split(", ");
			String suit = in[0];
			String diamonds = in[1], clubs = in[2], spades = in[3], hearts = in[4];

			int ace = 0, king = 0, queen = 0, jack = 0, ten = 0, nine = 0;

			switch (suit) {

			case "D":
				for (int j = 0; j < diamonds.length(); j++) {
					switch (diamonds.charAt(j)) {
					case 'A':
						ace++;
						break;
					case 'K':
						king++;
						break;
					case 'Q':
						queen++;
						break;
					case 'J':
						jack++;
						break;
					case 'T':
						ten++;
						break;
					}
				}

				if (ace == 2 && king == 2 && queen == 2 && jack == 2 && ten == 2) {
					points += 150;
				}

				

			case "C":
				for (int j = 0; j < clubs.length(); j++) {
					switch (clubs.charAt(j)) {
					case 'A':
						ace++;
						break;
					case 'K':
						king++;
						break;
					case 'Q':
						queen++;
						break;
					case 'J':
						jack++;
						break;
					case 'T':
						ten++;
						break;
					}
				}

				if (ace == 2 && king == 2 && queen == 2 && jack == 2 && ten == 2) {
					points += 150;
				}
				

			case "S":
				for (int j = 0; j < spades.length(); j++) {
					switch (spades.charAt(j)) {
					case 'A':
						ace++;
						break;
					case 'K':
						king++;
						break;
					case 'Q':
						queen++;
						break;
					case 'J':
						jack++;
						break;
					case 'T':
						ten++;
						break;
					}
				}

				if (ace == 2 && king == 2 && queen == 2 && jack == 2 && ten == 2) {
					points += 150;
				}

				
			case "H":
				for (int j = 0; j < hearts.length(); j++) {
					switch (hearts.charAt(j)) {
					case 'A':
						ace++;
						break;
					case 'K':
						king++;
						break;
					case 'Q':
						queen++;
						break;
					case 'J':
						jack++;
						break;
					case 'T':
						ten++;
						break;
					}
				}

				if (ace == 2 && king == 2 && queen == 2 && jack == 2 && ten == 2) {
					points += 150;
				}
				
			}

			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;

			for (int j = 0; j < diamonds.length(); j++) {
				if (diamonds.charAt(j) == 'J') {
					jack++;
				}
			}

			for (int j = 0; j < spades.length(); j++) {
				if (spades.charAt(j) == 'Q') {
					queen++;
				}
			}

			if (jack == 2 && queen == 2) {
				points += 30;
			}
			if(jack>=1 && queen>=1){
				points+=4;
			}
			jack = 0;
			queen = 0;

			for (int j = 0; j < diamonds.length(); j++) {
				if (diamonds.charAt(j) == 'A') {
					ace++;
				}
			}
			for (int j = 0; j < clubs.length(); j++) {
				if (clubs.charAt(j) == 'A') {
					ace++;
				}
			}
			for (int j = 0; j < spades.length(); j++) {
				if (spades.charAt(j) == 'A') {
					ace++;
				}
			}
			for (int j = 0; j < hearts.length(); j++) {
				if (hearts.charAt(j) == 'A') {
					ace++;
				}
			}
			

			if (ace >= 4) {
				points += 10;
			}
			if (ace == 8) {
				points += 110;
			}

			ace = 0;

			for (int j = 0; j < diamonds.length(); j++) {
				if (diamonds.charAt(j) == 'K') {
					king++;
				}
			}
			for (int j = 0; j < clubs.length(); j++) {
				if (clubs.charAt(j) == 'K') {
					king++;
				}
			}
			for (int j = 0; j < spades.length(); j++) {
				if (spades.charAt(j) == 'K') {
					king++;
				}
			}
			for (int j = 0; j < hearts.length(); j++) {
				if (hearts.charAt(j) == 'K') {
					king++;
				}
			}

			if (king >= 4) {
				points += 8;
			}
			if (king == 8) {
				points += 80;
			}

			king = 0;
			
			
			
			for (int j = 0; j < diamonds.length(); j++) {
				if (diamonds.charAt(j) == 'Q') {
					queen++;
				}
			}
			for (int j = 0; j < clubs.length(); j++) {
				if (clubs.charAt(j) == 'Q') {
					queen++;
				}
			}
			for (int j = 0; j < spades.length(); j++) {
				if (spades.charAt(j) == 'Q') {
					queen++;
				}
			}
			for (int j = 0; j < hearts.length(); j++) {
				if (hearts.charAt(j) == 'Q') {
					queen++;
				}
			}

			if (queen >= 4) {
				points += 6;
			}
			if (queen == 8) {
				points += 60;
			}

			queen = 0;
			
			
			for (int j = 0; j < diamonds.length(); j++) {
				if (diamonds.charAt(j) == 'J') {
					jack++;
			
				}
			}
			for (int j = 0; j < clubs.length(); j++) {
				if (clubs.charAt(j) == 'J') {
					jack++;
					
				}
			}
			for (int j = 0; j < spades.length(); j++) {
				if (spades.charAt(j) == 'J') {
					jack++;
					
				}
			}
			for (int j = 0; j < hearts.length(); j++) {
				if (hearts.charAt(j) == 'J') {
					jack++;
					
				}
			}

			if (jack >= 4) {
				points += 4;
			}
			if (jack == 8) {
				points += 40;
			}

			jack = 0;
			
			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;
			boolean trumpdiamond = false, trumpclubs = false, trumpspades = false, trumphearts = false;
			for(int j = 0; j < diamonds.length(); j++){
				if(diamonds.charAt(j)=='A'){
					ace++;
				}
				if(diamonds.charAt(j)=='K'){
					king++;
				}
				if(diamonds.charAt(j)=='Q'){
					queen++;
				}
				if(diamonds.charAt(j)=='J'){
					jack++;
				}
				if(diamonds.charAt(j)=='T'){
					ten++;
				}
			}
			if(ace>=1 && king>=1 && queen>=1 && jack>=1 && ten>=1){
				trumpdiamond = true;
			}
			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;
			for(int j = 0; j < clubs.length(); j++){
				if(clubs.charAt(j)=='A'){
					ace++;
				}
				if(clubs.charAt(j)=='K'){
					king++;
				}
				if(clubs.charAt(j)=='Q'){
					queen++;
				}
				if(clubs.charAt(j)=='J'){
					jack++;
				}
				if(clubs.charAt(j)=='T'){
					ten++;
				}
			}
			if(ace>=1 && king>=1 && queen>=1 && jack>=1 && ten>=1){
				trumpclubs = true;
			}
			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;
			for(int j = 0; j < spades.length(); j++){
				if(spades.charAt(j)=='A'){
					ace++;
				}
				if(spades.charAt(j)=='K'){
					king++;
				}
				if(spades.charAt(j)=='Q'){
					queen++;
				}
				if(spades.charAt(j)=='J'){
					jack++;
				}
				if(spades.charAt(j)=='T'){
					ten++;
				}
			}
			if(ace>=1 && king>=1 && queen>=1 && jack>=1 && ten>=1){
				trumpspades = true;
			}
			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;
			for(int j = 0; j < hearts.length(); j++){
				if(hearts.charAt(j)=='A'){
					ace++;
				}
				if(hearts.charAt(j)=='K'){
					king++;
				}
				if(hearts.charAt(j)=='Q'){
					queen++;
				}
				if(hearts.charAt(j)=='J'){
					jack++;
				}
				if(hearts.charAt(j)=='T'){
					ten++;
				}
			}
			if(ace>=1 && king>=1 && queen>=1 && jack>=1 && ten>=1){
				trumphearts = true;
			}
			ace = 0;
			king = 0;
			queen = 0;
			jack = 0;
			ten = 0;
			nine = 0;
			
			switch(suit){
			case "D":
				if(trumpclubs){
					points+=50;
				}
				if(trumpspades){
					points+=50;
				}
				if(trumphearts){
					points+=50;
				}
				break;
			case "C":
				if(trumpdiamond){
					points+=50;
				}
				if(trumpspades){
					points+=50;
				}
				if(trumphearts){
					points+=50;
				}
				break;
			case "S":
				if(trumpdiamond){
					points+=50;
				}
				if(trumpclubs){
					points +=50;
				}
				if(trumphearts){
					points+=50;
				}
				break;
			case "H":
				if(trumpdiamond){
					points+=50;
				}
				if(trumpspades){
					points+=50;
				}
				if(trumpclubs){
					points+=50;
				}
				break;
				
			}
			
			System.out.println((i+1)+". "+points);
			
			

		}

	}

}
