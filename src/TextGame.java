import java.awt.Color;
//Importing sound files
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

import hsa_new.Console;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import hsa_new.Console;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class TextGame {
// Setting pictures
	public static BufferedImage picRoadFork = null;
	public static BufferedImage picCabinPeter = null;
	public static BufferedImage picCreepyCabin = null;
	public static BufferedImage picOpenFeild = null;
	public static BufferedImage picFootprint = null;
	public static BufferedImage picDog = null;
	public static BufferedImage picHunter = null;
	public static BufferedImage picInsideCabin = null;
	public static BufferedImage picRicketyBridge = null;
	public static BufferedImage picRiver = null;
	public static BufferedImage picRockPath = null;
	public static BufferedImage picShadyFigure = null;
	public static BufferedImage picShrek = null;
	public static BufferedImage picTreeBlocksPath = null;
	public static BufferedImage picWolfPack = null;
	public static BufferedImage picBridge = null;	
	public static void main(String[] args) throws InterruptedException {
		Console c = new Console();
		
//Making variables for all the situations
		boolean playAgain = true;
		int trollAttack;
		int hunterAttack;
		int bridgeJump;
		int jumpCount = 1;
		int userGuess = 0;
		int userChoice2 = 0;
		String firstChoice;
		String treeChoice;
		String trollChoice;
		String dogName;
		String riverChoice;
		String cabinChoice;
		String hunterChoice;
		String playAgainChoice;
		String bridgeOption;
		String underOption;
		String runOption;
		String cabinOption;
		String mapOption;
		String trailOption;
//Importing pictures
		try {
			picRoadFork = ImageIO.read(TextGame.class.getResourceAsStream("fork_in_road.jpg"));
			picCabinPeter = ImageIO.read(TextGame.class.getResourceAsStream("CabinPeter.jpg"));
			picCreepyCabin = ImageIO.read(TextGame.class.getResourceAsStream("creepy_cabin.jpg"));
			picOpenFeild = ImageIO.read(TextGame.class.getResourceAsStream("feild.jpg"));
			picFootprint = ImageIO.read(TextGame.class.getResourceAsStream("footprint.jpg"));
			picDog = ImageIO.read(TextGame.class.getResourceAsStream("golden-retriever.jpg"));
			picHunter = ImageIO.read(TextGame.class.getResourceAsStream("hunter.jpg"));
			picInsideCabin = ImageIO.read(TextGame.class.getResourceAsStream("InsideCabin.jpg"));
			picRicketyBridge = ImageIO.read(TextGame.class.getResourceAsStream("ricketyBridge.jpg"));
			picRiver = ImageIO.read(TextGame.class.getResourceAsStream("river.jpg"));
			picRockPath = ImageIO.read(TextGame.class.getResourceAsStream("rockPath.jpg"));
			picShadyFigure = ImageIO.read(TextGame.class.getResourceAsStream("shadyFigure.jpg"));
			picShrek = ImageIO.read(TextGame.class.getResourceAsStream("shrek.jpg"));
			picTreeBlocksPath = ImageIO.read(TextGame.class.getResourceAsStream("tree_blocks_path.jpg"));
			picWolfPack = ImageIO.read(TextGame.class.getResourceAsStream("wolfPack.jpg"));
			picBridge = ImageIO.read(TextGame.class.getResourceAsStream("bridge.jpg"));
//Importing sounds			
			Clip river = AudioSystem.getClip();
			river.open(AudioSystem.getAudioInputStream(new File("RiverSounds.wav")));
			Clip CreepyMusic = AudioSystem.getClip();
			CreepyMusic.open(AudioSystem.getAudioInputStream(new File("CreepyMusic.wav")));
			
//making play again loop
			while (playAgain == true) 
			{
				//start of game
				c.println(" ");
				c.clear();
				c.println("Adam S has been missing for several days. You have been hired to find him.");
				Thread.sleep(2000);
				c.println("You have nothing but a pistol and your wit. The world is counting on you. ");
				Thread.sleep(2000);
				c.println("Goodluck soldier. THE WORLD NEEDS ADAM S!");
				Thread.sleep(4000);
				c.clear();
				c.drawImage(picRoadFork, 10, 10, 200, 200, null);
//first option, which way
				c.println("You come to a fork in the road. You can go left or right.");
				firstChoice = c.readLine();

				if (firstChoice.equalsIgnoreCase("Right")) 
				{
					//going right
					c.clear();
					Thread.sleep(500);
					c.drawImage(picTreeBlocksPath, 10, 10, 200, 200, null);
					c.println("A tree blocks your path. Walk around or Go back.");
					treeChoice = c.readLine();

					if (treeChoice.equalsIgnoreCase("Walk around")) 
						//walking around the tree
					{
						c.clear();
						c.drawImage(picShrek, 10, 10, 200, 200, null);
						c.println("You meet a troll behind the tree. Attack or Run.");
						trollChoice = c.readLine();

						if (trollChoice.equalsIgnoreCase("Attack")) 
							//attacking troll option, chance to survive
						{
							trollAttack = (int) (Math.random() * 10) + 1;

							if (trollAttack <= 5)
								//setting how likely you are to die
							{
								c.println("The troll has killed you. You were not successful in your hunt for Adam S");
							} 
							else 
							{
								//after killing the troll
								c.println("You successfully killed the troll. You are a lucky person.");
								Thread.sleep(500);
								c.clear();
								c.drawImage(picDog, 10, 10, 200, 200, null);
								c.println("You find a stray dog. Give it a name");
								dogName = c.readLine();
								Thread.sleep(500);
								c.clear();
								c.drawImage(picRiver, 10, 10, 200, 200, null);
								c.println("You come to a river. Drink water or keep looking");
								riverChoice = c.readLine();

								if (riverChoice.equalsIgnoreCase("Drink water")) 
								{
									//drink the water from the river
									river.start(); 
									Thread.sleep(500);
									c.clear();
									c.drawImage(picCreepyCabin, 10, 10, 200, 200, null);
									c.println("You come to a creepy looking cabin in the woods. Enter or keep walking.");
									cabinChoice = c.readLine();
									river.stop();

									if (cabinChoice.equalsIgnoreCase("Enter")) 
										//Enter the cabin to find Adam S
									{
										Thread.sleep(500);
										c.clear();
										c.println("Adam S is in the cabin. He gives you food, water, and transportation back home. Congratulations");
									} 
									
									else if (cabinChoice.equalsIgnoreCase("Keep walking")) 
										//Keep walking choice
									{
										Thread.sleep(500);
										c.clear();
										c.drawImage(picHunter, 10, 10, 200, 200, null);
										c.println("You meet a hunter in the forest. He doesn't trust you. Kill him or walk away.");
										hunterChoice = c.readLine();

										if (hunterChoice.equalsIgnoreCase("Kill him"))
											//attacking the hunter
										{
											hunterAttack = (int) (Math.random() * 15) + 1;
											Thread.sleep(500);

											if (hunterAttack <= 5)
												//killed the hunter chance
											{
												c.println("You have killed the hunter. You are scared and run back to the cabin");
												Thread.sleep(500);
												c.println("Adam S is in the cabin. He gives you food, water, and transportation back home. Congratulations");
											} 
											else if (hunterAttack > 5 && hunterAttack <= 10) 
											{
												//wound the hunter and run chance
												Thread.sleep(500);
												c.println("You have wounded the hunter. You turn and run back to the cabin before he gets up.");
												Thread.sleep(500);
												c.println("Adam S is in the cabin. He gives you food, water, and transportation back home. Congratulations");
											} 
											else 
												//killed by the hunter chance
											{
												Thread.sleep(500);
												c.println("The hunter has killed you. You were unsuccessful in finding Adam S.");
											}
										}
									}
								} 
								else if (riverChoice.equalsIgnoreCase("Keep looking")) 
									//keep looking death
								{
									Thread.sleep(500);
									c.println("After hours of looking you begin to get dehydrated. You pass out and eventually die. The dog eats you You have failed to find Adam S.");
								}
							}

						} 
						else if (trollChoice.equalsIgnoreCase("Run")) 
							//run from the troll
						{
							Thread.sleep(500);
							c.println("You turn and run into the forest.");
							Thread.sleep(250);
							c.drawImage(picBridge, 10, 10, 200, 200, null);
							c.println("You come to a bridge. It is very unstable. To get over safely you must guess the right number between 1 and 5.");
							bridgeJump = (int) (Math.random() * 5) + 1;

							while (jumpCount <= 3 && userGuess != bridgeJump) 
								//guessing the number
							{
								Thread.sleep(250);
								c.println("Guess a number");
								userGuess = Integer.parseInt(c.readLine());
								jumpCount++;
							}

							if (userGuess == bridgeJump) 
							{
								Thread.sleep(500);
								c.println("You guessed the right number and successfully got over the bridge.");
								Thread.sleep(500);
								c.println("You come to a cabin. Adam S is waiting for you inside. He gives you food, water, and transportation back home. Congratulations");
							} 
							else 
							{
								Thread.sleep(500);
								c.println("You guessed the wrong number. The brigde collapsed and you died");
								Thread.sleep(500);
								c.println("You were unable to find Adam S.");
							}

						}
					}
					else if (treeChoice.equalsIgnoreCase("Go back"))
					{
						//go back death
						Thread.sleep(500);
						c.println("On your way back a dog savages and kills you. You were unsuccessfull in the hunt for Adam S.");
					}

				}

				else if (firstChoice.equalsIgnoreCase("Left"))
					//going left at beginning of the game
				{
					c.drawImage(picRicketyBridge, 10, 10, 200, 200, null);
					c.println("You find a rickety bridge in the middle of nowhere, do you want to CROSS the bridge or go UNDER?");
					bridgeOption = c.readLine();
					Thread.sleep(500);

					if (bridgeOption.equalsIgnoreCase("CROSS")) {
						// crossing the bridge with percentage
						Thread.sleep(500);
						c.clear();
						int lifeChance = (int) (Math.random() * 10) + 1;
						if (lifeChance > 5) {

							c.println("You made it across safe and sound.");
							c.drawImage(picCabinPeter, 10, 10, 200, 200, null);
							c.println("As you reach solid land again you walk until you find a broken down house surrounded by a forest. It's sketchy from the outside, do you go into the HOUSE or go into the WOODS?");
							cabinOption = c.readLine();

							if (cabinOption.equalsIgnoreCase("House")) {
								//entering the house
								Thread.sleep(500);
								c.clear();
								c.drawImage(picInsideCabin, 10, 10, 200, 200, null);
								c.println("You enter a dusty house, it feels safe but mysterious. Fatigued you sit down and find a map on the table. Do you follow the MAP or go to SLEEP?");
								mapOption = c.readLine();

								if (mapOption.equalsIgnoreCase("MAP")) {
									//taking the math
									Thread.sleep(500);
									c.clear();
									int lifePercent = (int) (Math.random() * 10) + 1;
									if (lifePercent > 3) {
										//death by starvation
										Thread.sleep(500);
										c.clear();
										c.println("You die a painful death starving in the woods");
									} else {
										//Adam S win
										Thread.sleep(500);
										c.clear();
										c.println(
												"You begin to slowly fade away as a glowing figure comes to your rescue, it is ADAM S, YOU WIN!!!!!!!!!!");
									}
								} else {
									//after sleep
									Thread.sleep(500);
									c.clear();
									c.drawImage(picFootprint, 10, 10, 200, 200, null);
									c.println("You wake up refreshed and ready to explore, however when you get outside there are a fresh pair of footprints. Do you follow the FOOTPRINTS or follow the TRAIL on the map?");
									trailOption = c.readLine();
									if (trailOption.equalsIgnoreCase("FOOTPRINTS")) {
										//follow footprints to death
										c.println("You follow the footprints and without paying attention you fall into a deep hole. It was innevitable that you will spend your last days there.");

									} else {
										//find Adam S after refreshing sleep
										Thread.sleep(500);
										c.clear();
										c.println("You take the map, leaving the mysterious footprints behind. Without missing a step you follow the trail and end up with the man himself standing before you. Congratulations, you have found ADAM S!!!!!!!!!!!!!");

									}

								}
							}

							else {
								//chance to find Adam S
								Thread.sleep(500);
								c.clear();
								int adamChance = (int) (Math.random() * 10) + 1;
								if (adamChance > 7) {
									c.println("As you enter the dark woods something flashes by you. Ahead in the distance you see it...or not an it, but a him. ITS ADAM S, YOU WIN!!!!");
								} else {
									//animal gang game
									Thread.sleep(500);
									c.clear();
									c.drawImage(picWolfPack, 10, 10, 200, 200, null);
									c.println("You run into a pack of animals");
									int numberChoice = (int) (Math.random() * 10) + 1;
									for (int i = 1; i <= 3; i++) {
										c.println("Guess a number from 1 - 10");
										userChoice2 = Integer.parseInt(c.readLine());

										if (userChoice2 == numberChoice) {
											i = 4;
										}

									}

									if (userChoice2 == numberChoice) {
										Thread.sleep(500);
										c.clear();
										c.println("You guessed the right number, the animals show you the way to ADAM S!!!!!!!");
									}

									else {
										Thread.sleep(500);
										c.clear();
										c.println("You guessed wrong, you scream as the animals close in on you");
									}

								}

							}
						}

						else {
							//crossing the bridge death
							Thread.sleep(500);
							c.clear();
							c.println("As you cross the bridge everything snaps and you fall to your inevitable death.");

						}
					} else if (bridgeOption.equalsIgnoreCase("UNDER")) {
						//under the bridge instead of over
						Thread.sleep(500);
						c.clear();
						c.drawImage(picRockPath, 10, 10, 200, 200, null);
						c.println("You come upon a river after going under the bridge, what do you do? Will you SWIM across or take the ROCKS...");
						underOption = c.readLine();

						if (underOption.equalsIgnoreCase("SWIM")) {
							//Swim in the poisonous water death
							river.start();
							Thread.sleep(5000);
							c.clear();
							c.println("When you start swimming you are overpowered by the poisonous water and slowly die");
							river.stop();
						}

						else {
							//Taking the rock path
							CreepyMusic.start();
							Thread.sleep(500);
							c.clear();
							c.println("You hop across the rocks and come upon a small shore");
							c.drawImage(picShadyFigure, 10, 10, 200, 200, null);
							c.println("In the distance you see a shady figure run into the trees, do you RUN or FOLLOW?");
							runOption = c.readLine();
							CreepyMusic.stop();
							if (runOption.equalsIgnoreCase("RUN")) {
								//Choosing to run instead of follow death
								Thread.sleep(500);
								c.clear();
								c.println("You run as fast as you can, but the shady figure is catching up. You trip which leads to your own murder.");
							} else {
								//chasing Adam S option
								Thread.sleep(500);
								c.clear();
								c.println("As you chase down the person running away you begin to realize that they look familiar. It is then that you come into a clearing and they turn around. It's ADAM S!!!!!!!!!!! Congratulations you win :D");
							}
						}
					}
				}

				Thread.sleep(500);
				c.println("Would you like to play again? yes or no");
				playAgainChoice = c.readLine();
				//Play again option
				if (playAgainChoice.equalsIgnoreCase("yes")) {
					playAgain = true;
				} else if (playAgainChoice.equalsIgnoreCase("no")) {
					playAgain = false;
				}
			}
		}
		//Catching
		catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			e.printStackTrace();
			c.setTextColor(Color.RED);
			c.println("The program has failed. Please restart program");
			Thread.sleep(4000);
			c.close();
		}
		//closing program
		c.close();

	}
}
