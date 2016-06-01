package bitirme;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;
import zemberek.morphology.apps.TurkishMorphParser;
import zemberek.morphology.parser.MorphParse;

import java.io.*;

import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

import bitirme.Tokenizer;

public class main {
	public static void main(String[] args) throws IOException {
		 combineTrainingFiles("TestDataSet/negative",
		 "combinedNegativeTest.txt");
		 combineTrainingFiles("TestDataSet/positive",
		 "combinedPositiveTest.txt");
		 combineTrainingFiles("TestDataSet/neutral",
		 "combinedNeutralTest.txt");
		 maxentTestInputCreator();
		 maxentInputCreator();
		 maxentOurDatabase();
		 stemmedBigram("PositiveTestOnlyStem.txt",
		 "PositiveTestStemmedBigrams.txt");
		 stemmedBigram("NegativeTestOnlyStem.txt",
		 "NegativeTestStemmedBigrams.txt");
		 stemmedBigram("NeutralTestOnlyStem.txt",
		 "NeutralTestStemmedBigrams.txt");
		 //
		 seperator("combinedNeutralMaxent_3.txt","NeutralTestOnlyBigram.txt");
		 combiner("OnlyWordInput.txt", "OnlyStemInput.txt",
		 "WordStemInput.txt");
		 combiner("PositiveTestOnlyWord.txt", "PositiveTestOnlyBigram.txt",
		 "PositiveTestWordBigram.txt");
		 combiner("PositiveTestOnlyWord.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestWordSB.txt");
		 combiner("PositiveTestOnlyStem.txt", "PositiveTestOnlyBigram.txt",
		 "PositiveTestStemBigram.txt");
		 combiner("PositiveTestOnlyStem.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestStemSB.txt");
		 combiner("PositiveTestOnlyBigram.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestBigramSB.txt");
		 combiner("PositiveTestWordStem.txt", "PositiveTestOnlyBigram.txt",
		 "PositiveTestWordStemBigram.txt");
		 combiner("PositiveTestWordStem.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestWordStemSB.txt");
		 combiner("PositiveTestWordBigram.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestWordBigramSB.txt");
		 combiner("PositiveTestStemBigram.txt",
		 "PositiveTestStemmedBigrams.txt", "PositiveTestStemBigramSB.txt");
		 combiner("PositiveTestWordStemBigram.txt",
		 "PositiveTestStemmedBigrams.txt",
		 "PositiveTestWordStemBigramSB.txt");

		combiner("OnlyWordInput.txt", "OnlyStemmedBigrams.txt", "WordSBInput.txt");
		combiner("OnlyStemInput.txt", "OnlyStemmedBigrams.txt", "StemSBInput.txt");
		combiner("OnlyBigramInput.txt", "OnlyStemmedBigrams.txt", "BigramSBInput.txt");
		combiner("WordStemInput.txt", "OnlyStemmedBigrams.txt", "WordStemSBInput.txt");
		combiner("WordBigramInput.txt", "OnlyStemmedBigrams.txt", "WordBigramSBInput.txt");
		combiner("StemBigramInput.txt", "OnlyStemmedBigrams.txt", "StemBigramSBInput.txt");
		combiner("WordStemBigramInput.txt", "OnlyStemmedBigrams.txt", "WordStemBigramSBInput.txt");

		
		 combiner("NegativeTestOnlyWord.txt", "NegativeTestOnlyStem.txt",
		 "NegativeTestWordStem.txt");
		 combiner("NegativeTestOnlyWord.txt", "NegativeTestOnlyBigram.txt",
		 "NegativeTestWordBigram.txt");
		 combiner("NegativeTestOnlyWord.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestWordSB.txt");
		 combiner("NegativeTestOnlyStem.txt", "NegativeTestOnlyBigram.txt",
		 "NegativeTestStemBigram.txt");
		 combiner("NegativeTestOnlyStem.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestStemSB.txt");
		 combiner("NegativeTestOnlyBigram.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestBigramSB.txt");
		 combiner("NegativeTestWordStem.txt", "NegativeTestOnlyBigram.txt",
		 "NegativeTestWordStemBigram.txt");
		 combiner("NegativeTestWordStem.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestWordStemSB.txt");
		 combiner("NegativeTestWordBigram.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestWordBigramSB.txt");
		 combiner("NegativeTestStemBigram.txt",
		 "NegativeTestStemmedBigrams.txt", "NegativeTestStemBigramSB.txt");
		 combiner("NegativeTestWordStemBigram.txt",
		 "NegativeTestStemmedBigrams.txt",
		 "NegativeTestWordStemBigramSB.txt");
		
		 combiner("NeutralTestOnlyWord.txt", "NeutralTestOnlyStem.txt",
		 "NeutralTestWordStem.txt");
		 combiner("NeutralTestOnlyWord.txt", "NeutralTestOnlyBigram.txt",
		 "NeutralTestWordBigram.txt");
		 combiner("NeutralTestOnlyWord.txt", "NeutralTestStemmedBigrams.txt",
		 "NeutralTestWordSB.txt");
		 combiner("NeutralTestOnlyStem.txt", "NeutralTestOnlyBigram.txt",
		 "NeutralTestStemBigram.txt");
		 combiner("NeutralTestOnlyStem.txt", "NeutralTestStemmedBigrams.txt",
		 "NeutralTestStemSB.txt");
		 combiner("NeutralTestOnlyBigram.txt",
		 "NeutralTestStemmedBigrams.txt", "NeutralTestBigramSB.txt");
		 combiner("NeutralTestWordStem.txt", "NeutralTestOnlyBigram.txt",
		 "NeutralTestWordStemBigram.txt");
		 combiner("NeutralTestWordStem.txt", "NeutralTestStemmedBigrams.txt",
		 "NeutralTestWordStemSB.txt");
		 combiner("NeutralTestWordBigram.txt",
		 "NeutralTestStemmedBigrams.txt", "NeutralTestWordBigramSB.txt");
		 combiner("NeutralTestStemBigram.txt",
		 "NeutralTestStemmedBigrams.txt", "NeutralTestStemBigramSB.txt");
		 combiner("NeutralTestWordStemBigram.txt",
		 "NeutralTestStemmedBigrams.txt", "NeutralTestWordStemBigramSB.txt");
		//
		 bigram();
		 bigramInput();
		 combineTrainingFiles("negative", "combinedNegative.txt");
		 combineTrainingFiles("positive", "combinedPositive.txt");
		 combineTrainingFiles("neutral", "combinedNeutral.txt");
		// calculateWithDictionary();
		 MaxEnt m = new MaxEnt();
		 MaxEnt e = new MaxEnt();
		 e.MaximumEnthropy();
		// calculateWithOurDatabase();
		
		// readRates();

	}

	private static void stemmedBigram(String string, String string2) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input1 = new BufferedReader(new InputStreamReader(new FileInputStream(string), "UTF-8"));

		String temp1;
		String outputString = "";
		ArrayList<String> liste = new ArrayList<>();
		while ((temp1 = input1.readLine()) != null) {
			// String temp2 = temp1.substring((temp1.indexOf("s=")),
			// temp1.indexOf("bigram="));
			temp1 = temp1.replaceAll("s=", "");
			String[] stemmedWords = temp1.split(" ");
			for (int i = 0; i < stemmedWords.length - 1; i++)
				outputString += "sbi=" + stemmedWords[i] + "_" + stemmedWords[i + 1] + " ";

			liste.add(temp1.substring(0, 2) + outputString + "\n");
			outputString = "";
		}

		FileWriter f2 = new FileWriter(string2);
		for (String string3 : liste) {
			f2.write(string3);
		}

		f2.close();
	}

	private static void combiner(String string, String string2, String string3)
			throws IOException, FileNotFoundException {
		// TODO Auto-generated method stub
		BufferedReader input1 = new BufferedReader(new InputStreamReader(new FileInputStream(string), "UTF-8"));
		BufferedReader input2 = new BufferedReader(new InputStreamReader(new FileInputStream(string2), "UTF-8"));

		String temp1;
		String temp2;
		String outputString = "";
		while ((temp1 = input1.readLine()) != null && (temp2 = input2.readLine()) != null) {

			outputString += temp1 + temp2.substring(2) + "\n";

		}

		FileWriter f2 = new FileWriter(string3);

		f2.write(outputString);

		f2.close();
	}

	private static void seperator(String string, String string2) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(string), "UTF-8"));

		String temp;
		String outputString = "";
		while ((temp = input.readLine()) != null) {

			outputString += temp.substring(temp.indexOf("bigram=")) + "\n";

		}

		FileWriter f2 = new FileWriter(string2);

		f2.write(outputString);

		f2.close();

	}

	private static void bigramInput() throws IOException, FileNotFoundException {
		BufferedReader pos = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedPositive.txt"), "UTF-8"));
		StringBuilder posBuild = new StringBuilder();
		String temppos;
		while ((temppos = pos.readLine()) != null) {
			posBuild.append(temppos);
		}
		String positiveDic = posBuild.toString();
		// positiveDic = positiveDic.replaceAll("[^a-zA-Z ]", "");
		positiveDic = positiveDic.replaceAll("[!'\"<>.,]", "");
		// positiveDic.replaceAll("[(\")<>]", "");
		String[] PositiveWordDictionary = positiveDic.split(" ENDOFTWEET ");
		ArrayList<String> PWD = new ArrayList<>();
		ArrayList<String> NeuWD = new ArrayList<>();
		ArrayList<String> NWD = new ArrayList<>();

		for (String string : PositiveWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			PWD.add("1\t" + clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			PWD.add(bigrams + "\n");

		}

		BufferedReader neu = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNeutral.txt"), "UTF-8"));
		StringBuilder neutralBuild = new StringBuilder();
		String tempneutral;
		while ((tempneutral = neu.readLine()) != null) {
			neutralBuild.append(tempneutral);
		}
		String neuDictionary = neutralBuild.toString();
		neuDictionary = neuDictionary.replaceAll("[!'\"<>.,]", "");
		String[] neuWordDictionary = neuDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : neuWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			PWD.add("0\t" + clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			PWD.add(bigrams + "\n");
		}

		BufferedReader neg = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNegative.txt"), "UTF-8"));
		StringBuilder negativeBuild = new StringBuilder();
		String temp;
		while ((temp = neg.readLine()) != null) {
			negativeBuild.append(temp);
		}
		String NegativeDictionary = negativeBuild.toString();
		NegativeDictionary = NegativeDictionary.replaceAll("[!'\"<>.,]", "");
		String[] NegativeWordDictionary = NegativeDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : NegativeWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			PWD.add("2\t" + clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			PWD.add(bigrams + "\n");
		}

		FileWriter f2 = new FileWriter("combinedWordAndBigramInput.txt");
		for (String string : PWD) {
			f2.write(string);
		}
		f2.close();
	}

	private static void bigram() throws IOException {

		BufferedReader pos = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedPositiveTest.txt"), "UTF-8"));
		StringBuilder posBuild = new StringBuilder();
		String temppos;
		while ((temppos = pos.readLine()) != null) {
			posBuild.append(temppos);
		}
		String positiveDic = posBuild.toString();
		// positiveDic = positiveDic.replaceAll("[^a-zA-Z ]", "");
		positiveDic = positiveDic.replaceAll("[!'\"<>.,]", "");
		// positiveDic.replaceAll("[(\")<>]", "");
		String[] PositiveWordDictionary = positiveDic.split(" ENDOFTWEET ");
		ArrayList<String> PWD = new ArrayList<>();
		ArrayList<String> NeuWD = new ArrayList<>();
		ArrayList<String> NWD = new ArrayList<>();

		for (String string : PositiveWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			PWD.add(clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			PWD.add(bigrams + "\n");

		}
		FileWriter f = new FileWriter("combinedPositiveWordAndBigrams.txt");
		for (String string : PWD) {
			f.write(string);
		}
		f.close();
		BufferedReader neu = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNeutralTest.txt"), "UTF-8"));
		StringBuilder neutralBuild = new StringBuilder();
		String tempneutral;
		while ((tempneutral = neu.readLine()) != null) {
			neutralBuild.append(tempneutral);
		}
		String neuDictionary = neutralBuild.toString();
		neuDictionary = neuDictionary.replaceAll("[!'\"<>.,]", "");
		String[] neuWordDictionary = neuDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : neuWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NeuWD.add(clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NeuWD.add(bigrams + "\n");
		}
		FileWriter f1 = new FileWriter("combinedNeutralWordAndBigram.txt");
		for (String string : NeuWD) {
			f1.write(string);
		}
		f1.close();
		BufferedReader neg = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNegativeTest.txt"), "UTF-8"));
		StringBuilder negativeBuild = new StringBuilder();
		String temp;
		while ((temp = neg.readLine()) != null) {
			negativeBuild.append(temp);
		}
		String NegativeDictionary = negativeBuild.toString();
		NegativeDictionary = NegativeDictionary.replaceAll("[!'\"<>.,]", "");
		String[] NegativeWordDictionary = NegativeDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : NegativeWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NWD.add(clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NWD.add(bigrams + "\n");
		}

		FileWriter f2 = new FileWriter("combinedNegativeWordAndBigram.txt");
		for (String string : NWD) {
			f2.write(string);
		}
		f2.close();

	}

	public static void maxentTestInputCreator() throws IOException {
		BufferedReader pos = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedPositiveTest.txt"), "UTF-8"));
		StringBuilder posBuild = new StringBuilder();
		String temppos;
		while ((temppos = pos.readLine()) != null) {
			posBuild.append(temppos);
		}
		String positiveDic = posBuild.toString();
		// positiveDic = positiveDic.replaceAll("[^a-zA-Z ]", "");
		positiveDic = positiveDic.replaceAll("[!'\"<>.,]", "");
		// positiveDic.replaceAll("[(\")<>]", "");
		String[] PositiveWordDictionary = positiveDic.split(" ENDOFTWEET ");
		ArrayList<String> PWD = new ArrayList<>();
		ArrayList<String> NeuWD = new ArrayList<>();
		ArrayList<String> NWD = new ArrayList<>();

		for (String string : PositiveWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			PWD.add(clearedTweet);
			String tokenizedPos = Tokenizer.tokenIterator(clearedTweet);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			PWD.add(tokenizedPos);
			PWD.add(bigrams + "\n");
		}
		FileWriter f = new FileWriter("combinedPositiveMaxent_3.txt");
		for (String string : PWD) {
			f.write(string);
		}
		f.close();
		BufferedReader neu = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNeutralTest.txt"), "UTF-8"));
		StringBuilder neutralBuild = new StringBuilder();
		String tempneutral;
		while ((tempneutral = neu.readLine()) != null) {
			neutralBuild.append(tempneutral);
		}
		String neuDictionary = neutralBuild.toString();
		neuDictionary = neuDictionary.replaceAll("[!'\"<>.,]", "");
		String[] neuWordDictionary = neuDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : neuWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NeuWD.add(clearedTweet);
			String tokenizedNeu = Tokenizer.tokenIterator(clearedTweet);
			NeuWD.add(tokenizedNeu);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NeuWD.add(bigrams + "\n");
		}
		FileWriter f1 = new FileWriter("combinedNeutralMaxent_3.txt");
		for (String string : NeuWD) {
			f1.write(string);
		}
		f1.close();
		BufferedReader neg = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNegativeTest.txt"), "UTF-8"));
		StringBuilder negativeBuild = new StringBuilder();
		String temp;
		while ((temp = neg.readLine()) != null) {
			negativeBuild.append(temp);
		}
		String NegativeDictionary = negativeBuild.toString();
		NegativeDictionary = NegativeDictionary.replaceAll("[!'\"<>.,]", "");
		String[] NegativeWordDictionary = NegativeDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : NegativeWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NWD.add(clearedTweet);
			String tokenizedNeg = Tokenizer.tokenIterator(clearedTweet);
			NWD.add(tokenizedNeg);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NWD.add(bigrams + "\n");
		}

		FileWriter f2 = new FileWriter("combinedNegativeMaxent_3.txt");
		for (String string : NWD) {
			f2.write(string);
		}
		f2.close();
	}

	public static void maxentInputCreator() throws IOException {
		BufferedReader pos = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedPositive.txt"), "UTF-8"));
		StringBuilder posBuild = new StringBuilder();
		String temppos;
		while ((temppos = pos.readLine()) != null) {
			posBuild.append(temppos);
		}
		String positiveDic = posBuild.toString();
		// positiveDic = positiveDic.replaceAll("[^a-zA-Z ]", "");
		positiveDic = positiveDic.replaceAll("[!'\"<>.,]", "");
		// positiveDic.replaceAll("[(\")<>]", "");
		String[] PositiveWordDictionary = positiveDic.split(" ENDOFTWEET ");
		ArrayList<String> NWD = new ArrayList<>();

		for (String string : PositiveWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NWD.add("1\t" + clearedTweet);
			String tokenizedPos = Tokenizer.tokenIterator(clearedTweet);
			NWD.add(tokenizedPos);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NWD.add(bigrams + "\n");

		}

		BufferedReader neu = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNeutral.txt"), "UTF-8"));
		StringBuilder neutralBuild = new StringBuilder();
		String tempneutral;
		while ((tempneutral = neu.readLine()) != null) {
			neutralBuild.append(tempneutral);
		}
		String neuDictionary = neutralBuild.toString();
		neuDictionary = neuDictionary.replaceAll("[!'\"<>.,]", "");
		String[] neuWordDictionary = neuDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : neuWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NWD.add("0\t" + clearedTweet);
			String tokenizedNeu = Tokenizer.tokenIterator(clearedTweet);
			NWD.add(tokenizedNeu);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NWD.add(bigrams + "\n");
		}

		BufferedReader neg = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNegative.txt"), "UTF-8"));
		StringBuilder negativeBuild = new StringBuilder();
		String temp;
		while ((temp = neg.readLine()) != null) {
			negativeBuild.append(temp);
		}
		String NegativeDictionary = negativeBuild.toString();
		NegativeDictionary = NegativeDictionary.replaceAll("[!'\"<>.,]", "");
		String[] NegativeWordDictionary = NegativeDictionary.split(" ENDOFTWEET ");
		// ArrayList<String> NWD = new ArrayList<>();

		for (String string : NegativeWordDictionary) {
			String[] tweet = string.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("http") || string2.startsWith("RT") || string2.startsWith("@")
						|| string2.startsWith("#"))
					continue;
				clearedTweet += string2 + " ";
			}

			NWD.add("2\t" + clearedTweet);
			String tokenizedNeg = Tokenizer.tokenIterator(clearedTweet);
			NWD.add(tokenizedNeg);
			String[] bigramCreator = clearedTweet.split(" ");

			String bigrams = "";
			for (int i = 0; i < bigramCreator.length - 1; i++) {
				bigrams += "bigram=" + bigramCreator[i] + "_" + bigramCreator[i + 1] + " ";
			}

			NWD.add(bigrams + "\n");
		}

		FileWriter f = new FileWriter("combinedForMaxent_Triple.txt");
		for (String string : NWD) {
			f.write(string);
		}
		f.close();
	}

	// public static void readRates() throws UnsupportedEncodingException,
	// FileNotFoundException, IOException {
	// File[] allPositivefiles = new File("positive").listFiles();
	// BufferedReader inpositive = null;
	// StringBuilder sbpositive = new StringBuilder();
	//
	// for (File f : allPositivefiles) {
	//
	// if (f.getName().endsWith(".txt")) {
	// inpositive = new BufferedReader(new InputStreamReader(new
	// FileInputStream(f), "UTF-8"));
	// ;
	//
	// String s = null;
	// while ((s = inpositive.readLine()) != null) {
	// sbpositive.append(s);
	// sbpositive.append("ENDTWEET");
	// }
	// }
	// }
	//
	// inpositive.close();
	//
	// String tweets = sbpositive.toString();
	//
	// String oneTweet = "";
	//
	// Map<String, Integer> PositiveWordNumbers = new HashMap<String,
	// Integer>();
	// int i = 0;
	// PrintWriter writer = new PrintWriter("baseLine.txt");
	// while (tweets.length() > 0) {
	// int startOfTweet = 0;
	// int endOfTweet = tweets.indexOf("ENDTWEET");
	// oneTweet = tweets.substring(startOfTweet, endOfTweet);
	// oneTweet = oneTweet.toLowerCase();
	// ArrayList<String> words = new ArrayList<String>();
	// i++;
	// words = Tokenizer.tokenIterator(oneTweet);
	// System.out.println("positive =" + i + " =" + oneTweet);
	// for (String string : words) {
	// if (PositiveWordNumbers.containsKey(string)) {
	// PositiveWordNumbers.replace(string, PositiveWordNumbers.get(string) + 1);
	// } else {
	// PositiveWordNumbers.put(string, 1);
	// }
	// }
	// tweets = tweets.substring(tweets.indexOf("ENDTWEET") + 8);
	//
	// }
	//
	// File[] allNegativefiles = new File("negative").listFiles();
	// BufferedReader innegative = null;
	// StringBuilder sbnegative = new StringBuilder();
	//
	// for (File f : allNegativefiles) {
	//
	// if (f.getName().endsWith(".txt")) {
	// innegative = new BufferedReader(new InputStreamReader(new
	// FileInputStream(f), "UTF-8"));
	// ;
	//
	// String s = null;
	// while ((s = innegative.readLine()) != null) {
	// sbnegative.append(s);
	// sbnegative.append("ENDTWEET");
	// }
	// }
	// }
	//
	// innegative.close();
	//
	// String negativetweets = sbnegative.toString();
	//
	// String oneNegativeTweet = "";
	//
	// Map<String, Integer> NegativeWordNumbers = new HashMap<String,
	// Integer>();
	//
	// // PrintWriter writer = new PrintWriter("baseLine.txt");
	// int j = 0;
	// while (negativetweets.length() > 0) {
	// int startOfTweet = 0;
	// int endOfTweet = negativetweets.indexOf("ENDTWEET");
	// oneNegativeTweet = negativetweets.substring(startOfTweet, endOfTweet);
	// oneNegativeTweet = oneNegativeTweet.toLowerCase();
	// ArrayList<String> words = new ArrayList<String>();
	// j++;
	// words = Tokenizer.tokenIterator(oneNegativeTweet);
	// System.out.println("negative =" + j + "=" + oneNegativeTweet);
	// for (String string : words) {
	// if (NegativeWordNumbers.containsKey(string)) {
	// NegativeWordNumbers.replace(string, NegativeWordNumbers.get(string) + 1);
	// } else {
	// NegativeWordNumbers.put(string, 1);
	// }
	// }
	// negativetweets =
	// negativetweets.substring(negativetweets.indexOf("ENDTWEET") + 8);
	//
	// }
	//
	// File[] allNeutralfiles = new File("neutral").listFiles();
	// BufferedReader inNeutral = null;
	// StringBuilder sbNeutral = new StringBuilder();
	//
	// for (File f : allNeutralfiles) {
	//
	// if (f.getName().endsWith(".txt")) {
	// inNeutral = new BufferedReader(new InputStreamReader(new
	// FileInputStream(f), "UTF-8"));
	// ;
	//
	// String s = null;
	// while ((s = inNeutral.readLine()) != null) {
	// sbNeutral.append(s);
	// sbNeutral.append("ENDTWEET");
	// }
	// }
	// }
	//
	// inNeutral.close();
	//
	// String neutraltweets = sbNeutral.toString();
	//
	// String oneneutralTweet = "";
	//
	// Map<String, Integer> neutralWordNumbers = new HashMap<String, Integer>();
	// int k = 0;
	// while (neutraltweets.length() > 0) {
	// int startOfTweet = 0;
	// int endOfTweet = neutraltweets.indexOf("ENDTWEET");
	// oneneutralTweet = neutraltweets.substring(startOfTweet, endOfTweet);
	// oneneutralTweet = oneneutralTweet.toLowerCase();
	// ArrayList<String> words = new ArrayList<String>();
	// k++;
	// words = Tokenizer.tokenIterator(oneneutralTweet);
	// System.out.println("neutral =" + k + "=" + oneneutralTweet);
	// for (String string : words) {
	// if (neutralWordNumbers.containsKey(string)) {
	// neutralWordNumbers.replace(string, neutralWordNumbers.get(string) + 1);
	// } else {
	// neutralWordNumbers.put(string, 1);
	// }
	// }
	// neutraltweets = neutraltweets.substring(neutraltweets.indexOf("ENDTWEET")
	// + 8);
	//
	// }
	// writer.close();
	// PrintWriter Oranlar = new PrintWriter("oranlar.txt");
	// for (String s : PositiveWordNumbers.keySet()) {
	// ArrayList<Double> val = new ArrayList<>();
	// int total = 0;
	// int numbersInPositive = PositiveWordNumbers.get(s);
	// int numbersInNeutral = 0;
	// int numbersInNegative = 0;
	// if (neutralWordNumbers.containsKey(s)) {
	// numbersInNeutral = neutralWordNumbers.get(s);
	// neutralWordNumbers.remove(s);
	// }
	// if (NegativeWordNumbers.containsKey(s)) {
	// numbersInNegative = NegativeWordNumbers.get(s);
	// NegativeWordNumbers.remove(s);
	// }
	// total = numbersInPositive + numbersInNegative + numbersInNeutral;
	// val.add(0, (double) numbersInNegative / (double) total);
	// val.add(1, (double) numbersInNeutral / (double) total);
	// val.add(2, (double) numbersInPositive / (double) total);
	// Oranlar.println(s + "|" + val.get(0) + "|" + val.get(1) + "|" +
	// val.get(2));
	// }
	//
	// for (String s : neutralWordNumbers.keySet()) {
	// ArrayList<Double> val = new ArrayList<>();
	// int total = 0;
	// int numbersInNeutral = neutralWordNumbers.get(s);
	// int numbersInNegative = 0;
	// if (NegativeWordNumbers.containsKey(s)) {
	// numbersInNegative = NegativeWordNumbers.get(s);
	// NegativeWordNumbers.remove(s);
	// }
	// total = numbersInNegative + numbersInNeutral;
	// val.add(0, (double) numbersInNegative / (double) total);
	// val.add(1, (double) numbersInNeutral / (double) total);
	// val.add(2, 0.0);
	// Oranlar.println(s + "|" + val.get(0) + "|" + val.get(1) + "|" +
	// val.get(2));
	// }
	//
	// for (String s : NegativeWordNumbers.keySet()) {
	// ArrayList<Double> val = new ArrayList<>();
	// int total = 0;
	// int numbersInNegative = NegativeWordNumbers.get(s);
	//
	// total = numbersInNegative;
	// val.add(0, 1.0);
	// val.add(1, 0.0);
	// val.add(2, 0.0);
	// Oranlar.println(s + "|" + val.get(0) + "|" + val.get(1) + "|" +
	// val.get(2));
	// }
	// Oranlar.close();
	// }
	public static void combineTrainingFiles(String directory, String outputName)
			throws NumberFormatException, IOException {
		File[] allPositivefiles = new File(directory).listFiles();
		BufferedReader inpositive = null;
		StringBuilder sbpositive = new StringBuilder();

		for (File f : allPositivefiles) {

			if (f.getName().endsWith(".txt")) {
				inpositive = new BufferedReader(new InputStreamReader(new FileInputStream(f), "UTF-8"));
				;

				String s = null;
				while ((s = inpositive.readLine()) != null) {
					sbpositive.append(s);
					sbpositive.append(" ENDOFTWEET ");
				}
			}
		}

		inpositive.close();
		FileWriter f = new FileWriter(outputName);
		f.write(sbpositive.toString());
		f.close();
	}

	// /*String kelime = null;
	// while ((kelime = oranlar.readLine()) != null) {
	// StringBuilder oranString = new StringBuilder();
	// oranString.append(kelime);
	//
	// String input = oranString.toString();
	// ArrayList<Double> ratesOfWord = new ArrayList<>();
	// String key = input.substring(0, input.indexOf("|"));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(0, Double.parseDouble(input.substring(0,
	// input.indexOf("|"))));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(1, Double.parseDouble(input.substring(0,
	// input.indexOf("|"))));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(2, Double.parseDouble(input));
	// rates.put(key, new ArrayList<>(ratesOfWord));
	//
	// }
	// oranlar.close();*/
	// String tweets = sbpositive.toString();
	// //String oneTweet = "";
	// PrintWriter writer = new PrintWriter(outputName);
	// writer.print(tweets);
	// writer.close();
	// }
	//
	// public static void calculateWithOurDatabase()
	// throws UnsupportedEncodingException, FileNotFoundException, IOException {
	// File[] allPositivefiles = new File("negativeCombined").listFiles();
	// BufferedReader inpositive = null;
	// StringBuilder sbpositive = new StringBuilder();
	//
	// for (File f : allPositivefiles) {
	//
	// if (f.getName().endsWith(".txt")) {
	// inpositive = new BufferedReader(new InputStreamReader(new
	// FileInputStream(f), "UTF-8"));
	// ;
	//
	// String s = null;
	// while ((s = inpositive.readLine()) != null) {
	// sbpositive.append(s);
	// sbpositive.append("ENDTWEET");
	// }
	// }
	// }
	//
	// inpositive.close();
	//
	// BufferedReader oranlar = new BufferedReader(new InputStreamReader(new
	// FileInputStream("oranlar.txt"), "UTF-8"));
	//
	// Map<String, ArrayList<Double>> rates = new HashMap<String,
	// ArrayList<Double>>();
	//
	// String kelime = null;
	// while ((kelime = oranlar.readLine()) != null) {
	// StringBuilder oranString = new StringBuilder();
	// oranString.append(kelime);
	//
	// String input = oranString.toString();
	// ArrayList<Double> ratesOfWord = new ArrayList<>();
	// String key = input.substring(0, input.indexOf("|"));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(0, Double.parseDouble(input.substring(0,
	// input.indexOf("|"))));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(1, Double.parseDouble(input.substring(0,
	// input.indexOf("|"))));
	// input = input.substring(input.indexOf("|") + 1);
	// ratesOfWord.add(2, Double.parseDouble(input));
	// rates.put(key, new ArrayList<>(ratesOfWord));
	//
	// }
	// oranlar.close();
	// String tweets = sbpositive.toString();
	// String oneTweet = "";
	// PrintWriter writer = new PrintWriter("baseLineOurDatabaseTest.txt");
	// int i = 0;
	// while (tweets.length() > 0) {
	// int startOfTweet = 0;
	// int endOfTweet = tweets.indexOf("ENDTWEET");
	// oneTweet = tweets.substring(startOfTweet, endOfTweet);
	// oneTweet = oneTweet.toLowerCase();
	// ArrayList<String> words = new ArrayList<String>();
	// i++;
	// words = Tokenizer.tokenIterator(oneTweet);
	// System.out.println("positive =" + i + " =" + oneTweet);
	// baseLine(oneTweet, words, writer, rates);
	// tweets = tweets.substring(tweets.indexOf("ENDTWEET") + 8);
	//
	// }
	// writer.close();
	// }
	//
	// private static void baseLine(String oneTweet, ArrayList<String> words,
	// PrintWriter writer,
	// Map<String, ArrayList<Double>> wordValueMap) {
	// double result = 0;
	// double effect = 0;
	// int index = 0;
	// for (String word : words) {
	// if (wordValueMap.containsKey(word)) {
	//
	// for (int i = 0; i < 3; i++) {
	// ArrayList<Double> values = new ArrayList<Double>();
	// values.addAll(wordValueMap.get(word));
	// if (values.get(i) > effect) {
	//
	// effect = values.get(i);
	// index = i;
	// }
	// }
	// }
	// if (index == 0) {
	// result -= effect;
	// } else if (index == 2) {
	// result += effect;
	// }
	// }
	// if (result < 0) {
	// writer.println(oneTweet + "-> Negative");
	// } else if (result > 0) {
	// writer.println(oneTweet + "-> Positive");
	// } else {
	// writer.println(oneTweet + "-> Neutral");
	// }
	// }
	//
	public static void maxentOurDatabase() throws UnsupportedEncodingException, FileNotFoundException, IOException {
		BufferedReader neg = new BufferedReader(
				new InputStreamReader(new FileInputStream("combinedNegativeMaxent_3.txt"), "UTF-8"));
		StringBuilder negativeBuild = new StringBuilder();
		String temp;

		BufferedReader oranlar = new BufferedReader(new InputStreamReader(new FileInputStream("oranlar.txt"), "UTF-8"));

		Map<String, ArrayList<Double>> rates = new HashMap<String, ArrayList<Double>>();

		String kelime = null;
		while ((kelime = oranlar.readLine()) != null) {
			StringBuilder oranString = new StringBuilder();
			oranString.append(kelime);

			String input = oranString.toString();
			ArrayList<Double> ratesOfWord = new ArrayList<>();
			String key = input.substring(0, input.indexOf("|"));
			input = input.substring(input.indexOf("|") + 1);
			ratesOfWord.add(0, Double.parseDouble(input.substring(0, input.indexOf("|"))));
			input = input.substring(input.indexOf("|") + 1);
			ratesOfWord.add(1, Double.parseDouble(input.substring(0, input.indexOf("|"))));
			input = input.substring(input.indexOf("|") + 1);
			ratesOfWord.add(2, Double.parseDouble(input));
			rates.put(key, new ArrayList<>(ratesOfWord));

		}
		oranlar.close();

		while ((temp = neg.readLine()) != null) {
			negativeBuild.append(temp);
		}
		String NegativeDictionary = negativeBuild.toString();
		NegativeDictionary = NegativeDictionary.replaceAll("[!'\"<>.,]", "");
		String[] oneTweet = NegativeDictionary.split("\t");
		// ArrayList<String> NWD = new ArrayList<>();

		ArrayList<String> NWD = new ArrayList<>();

		while (NegativeDictionary.contains("s=")) {
			String tempTweet;
			// if(string.contains("s=")){
			// String[] tweet = string.split(" ");
			try {
				tempTweet = NegativeDictionary.substring(0, NegativeDictionary.indexOf("\t", 3) - 1);
			} catch (Exception e) {
				tempTweet = NegativeDictionary;
			}
			System.out.println(tempTweet);
			System.out.println("first=" + tempTweet.indexOf("s="));
			System.out.println("second=" + tempTweet.indexOf("bigram="));

			tempTweet = tempTweet.substring(tempTweet.indexOf("s="), tempTweet.indexOf("bigram="));
			String[] tweet = tempTweet.split(" ");
			String clearedTweet = "";
			for (String string2 : tweet) {

				if (string2.startsWith("s=")) {

					double resultRate = 0;
					int index = 0;
					String stemmed = string2.substring(2);

					for (int i = 0; i < 3; i++) {
						ArrayList<Double> values = new ArrayList<Double>();
						if (rates.containsKey(stemmed)) {
							values.addAll(rates.get(stemmed));
							if (values.get(i) > resultRate) {

								resultRate = values.get(i);
								index = i;
							}
						}
					}

					if (index == 1)
						resultRate = 0;
					else if (index == 2)
						resultRate = -resultRate;
					clearedTweet += "rate=" + stemmed + ":" + resultRate + " ";
					// }

					// }

				}

			}
			NWD.add(clearedTweet + "\n");
			try {
				NegativeDictionary = NegativeDictionary.substring(NegativeDictionary.indexOf("bigram=") + 1);
				NegativeDictionary = NegativeDictionary.substring(NegativeDictionary.indexOf("s="));
			} catch (Exception ex) {
				NegativeDictionary = "";
				break;
			}
		}
		FileWriter f = new FileWriter("Negative_Dict.txt");
		for (String string : NWD) {
			f.write(string);
		}
		f.close();

	}

	private static void baseLine(String oneTweet, ArrayList<String> words, PrintWriter writer,
			Map<String, ArrayList<Double>> wordValueMap) {
		double result = 0;
		double effect = 0;
		int index = 0;
		for (String word : words) {
			if (wordValueMap.containsKey(word)) {

				for (int i = 0; i < 3; i++) {
					ArrayList<Double> values = new ArrayList<Double>();
					values.addAll(wordValueMap.get(word));
					if (values.get(i) > effect) {

						effect = values.get(i);
						index = i;
					}
				}
			}
			if (index == 0) {
				result -= effect;
			} else if (index == 2) {
				result += effect;
			}
		}
		if (result < 0) {
			writer.println(oneTweet + "-> Negative");
		} else if (result > 0) {
			writer.println(oneTweet + "-> Positive");
		} else {
			writer.println(oneTweet + "-> Neutral");
		}
	}
	// public static void takeTweetsFromConsole(String keyword) throws
	// IOException {
	// /*
	// * if (args.length < 1) { System.out.println(
	// * "java twitter4j.examples.search.SearchTweets [query]");
	// * System.exit(-1); }
	// */
	// BufferedWriter out = new BufferedWriter(new FileWriter("file1.txt"));
	// // Twitter twitter = new TwitterFactory().getInstance();
	// try {
	// int i = 209;
	// Query query = new Query(keyword);
	// QueryResult result;
	// do {
	// ConfigurationBuilder cb = new ConfigurationBuilder();
	// cb.setDebugEnabled(true).setOAuthConsumerKey("AefOjLks5ZoQuPJWAx1xouRYS")
	// .setOAuthConsumerSecret("sBi3mPem1MStK6g5OQp84buRpRweFiC92hZVZUqF2xVPifuTjD")
	// .setOAuthAccessToken("167362117-xmjT0vAQxNiO6aqUtsdYmp59gc3LpNZqAaIdtQv4")
	// .setOAuthAccessTokenSecret("6QJqBP7b2wFWDCqk63ydAa8EYzkkqFavOrpfDCCWsXpiZ");
	//
	// TwitterFactory tf = new TwitterFactory(cb.build());
	// Twitter twitter = tf.getInstance();
	// result = twitter.search(query);
	// List<Status> tweets = result.getTweets();
	//
	// String twit = "";
	//
	// for (Status tweet : tweets) {
	//
	// twit = " - " + tweet.getText();
	// out.write((i + 1) + ") ");
	// out.write(twit);
	// out.newLine();
	// System.out.println(twit);
	// // Tokenizer t = new Tokenizer();
	// // t.tokenizer(twit);
	// i++;
	// }
	//
	// } while ((query = result.nextQuery()) != null);
	//
	// out.close();
	// System.exit(0);
	// } catch (TwitterException te) {
	// te.printStackTrace();
	// System.out.println("Failed to search tweets: " + te.getMessage());
	// System.exit(-1);
	// }
	// }
	//
	// public static Map<String, List<Double>> ExcelReader() {
	// try {
	// String file = "C:\\Users\\Oguzhan\\workspace\\bitirme\\STNsubset.xls";
	// POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(file));
	// HSSFWorkbook wb = new HSSFWorkbook(fs);
	// HSSFSheet sheet = wb.getSheetAt(0);
	// HSSFRow row;
	// HSSFCell cell;
	//
	// int rows; // No of rows
	// rows = sheet.getPhysicalNumberOfRows();
	//
	// int cols = 4; // No of columns
	//
	// Map<String, List<Double>> mymap = new HashMap<String, List<Double>>();
	// ArrayList<Double> values = new ArrayList<Double>();
	// ArrayList<Double> temp = new ArrayList<Double>();
	//
	// for (int r = 0; r < rows; r++) {
	//
	// row = sheet.getRow(r);
	// values.clear();
	// if (row != null) {
	// TurkishMorphParser parser;
	// String[] kelimeler = row.getCell(0).toString().split(" , ");
	// parser = TurkishMorphParser.createWithDefaults();
	// ArrayList<String> lemmas = new ArrayList<>();
	//
	// for (int c = 1; c < cols; c++) {
	// cell = row.getCell(c);
	// if (cell != null) {
	// values.add(Double.parseDouble(cell.toString()));
	//
	// }
	// }
	// for (String s : kelimeler) {
	// List<MorphParse> parses = parser.parse(s);
	// if (parses.size() > 0) {
	//
	// mymap.put(parses.get(0).getLemma(), new ArrayList<Double>(values));
	// } else {
	// mymap.put(s, new ArrayList<Double>(values));
	// }
	// }
	//
	// }
	// }
	// PrintWriter writer = new PrintWriter("map.txt");
	// for (String s : mymap.keySet()) {
	//
	// writer.println(s + "|" + mymap.get(s).get(0) + "|" + mymap.get(s).get(1)
	// + "|" + mymap.get(s).get(2));
	//
	// }
	// return mymap;
	// }
	//
	// catch (Exception ioe) {
	//
	// ioe.printStackTrace();
	// return null;
	// }
	// }
	//
	// public static ArrayList<String> tokenizer(String tweet) {
	// ArrayList<String> tokens = new ArrayList<String>();
	// String oneWord = "";
	// // tweet = tweet.replaceAll("[.,']", "");
	// tweet = tweet.replaceAll("[!?>.,'<)(;\r:\n\t\"]", " ");
	// tweet = tweet.replace('ý', 'i');
	// tweet = tweet.replace('Ý', 'I');
	// tweet = tweet.replace('ü', 'u');
	// tweet = tweet.replace('Ü', 'U');
	// tweet = tweet.replace('ð', 'g');
	// tweet = tweet.replace('Ð', 'g');
	// tweet = tweet.replace('ö', 'o');
	// tweet = tweet.replace('Ö', 'O');
	// tweet = tweet.replace('Ç', 'C');
	// tweet = tweet.replace('ç', 'c');
	// tweet = tweet.replace('Þ', 'S');
	// tweet = tweet.replace('s', 's');
	//
	// while (!tweet.isEmpty()) {
	// oneWord = tweet.substring(0, tweet.indexOf(" "));
	// if (!(oneWord.startsWith("#") || oneWord.startsWith("@") ||
	// oneWord.startsWith("https://")
	// || oneWord.startsWith("http://"))) {
	// tokens.add(oneWord);
	// }
	// if (tweet.contains(" ")) {
	// tweet = tweet.substring(tweet.indexOf(" ") + 1);
	// } else {
	// tweet = "";
	// }
	//
	// }
	// return tokens;
	// }
	//
	// public static void calculateWithDictionary() throws IOException {
	// BufferedReader neg = new BufferedReader(new InputStreamReader(new
	// FileInputStream("negativeNew.txt"), "UTF-8"));
	// StringBuilder negativeBuild = new StringBuilder();
	// String temp;
	// while ((temp = neg.readLine()) != null) {
	// negativeBuild.append(temp);
	// }
	// String NegativeDictionary = negativeBuild.toString();
	// String[] NegativeWordDictionary = NegativeDictionary.split("#n");
	// ArrayList<String> NWD = new ArrayList<>();
	// for (String string : NegativeWordDictionary) {
	// NWD.add(string);
	// }
	//
	// BufferedReader pos = new BufferedReader(new InputStreamReader(new
	// FileInputStream("positiveNew.txt"), "UTF-8"));
	// StringBuilder positiveBuild = new StringBuilder();
	// String tempp;
	// while ((tempp = pos.readLine()) != null) {
	// positiveBuild.append(tempp);
	// }
	// String PositiveDictionary = positiveBuild.toString();
	// String[] PositiveWordDictionary = PositiveDictionary.split("#n");
	// ArrayList<String> PWD = new ArrayList<>();
	// for (String string : PositiveWordDictionary) {
	// PWD.add(string);
	// }
	//
	// File[] allPositivefiles = new File("TestDataSet/negative").listFiles();
	// BufferedReader inpositive = null;
	// StringBuilder sbpositive = new StringBuilder();
	//
	// for (File f : allPositivefiles) {
	//
	// if (f.getName().endsWith(".txt")) {
	// inpositive = new BufferedReader(new InputStreamReader(new
	// FileInputStream(f), "UTF-8"));
	// ;
	//
	// String s = null;
	// while ((s = inpositive.readLine()) != null) {
	// sbpositive.append(s);
	// sbpositive.append("ENDTWEET");
	// }
	// }
	// }
	//
	// inpositive.close();
	//
	// String tweets = sbpositive.toString();
	// String oneTweet = "";
	// PrintWriter writer = new PrintWriter("baseLineDictionaryTest.txt");
	// int i = 0;
	// while (tweets.length() > 0) {
	// int startOfTweet = 0;
	// int endOfTweet = tweets.indexOf("ENDTWEET");
	// oneTweet = tweets.substring(startOfTweet, endOfTweet);
	// oneTweet = oneTweet.toLowerCase();
	// ArrayList<String> words = new ArrayList<String>();
	// i++;
	// words = Tokenizer.tokenIterator(oneTweet);
	// System.out.println("positive =" + i + " =" + oneTweet);
	//
	// double result = 0;
	// for (String string : words) {
	// if (PWD.contains(string)) {
	// result++;
	// }
	// if (NWD.contains(string)) {
	// result--;
	// }
	// }
	//
	// if (result < 0) {
	// writer.println(oneTweet + "-> Negative");
	// } else if (result > 0) {
	// writer.println(oneTweet + "-> Positive");
	// } else {
	// writer.println(oneTweet + "-> Neutral");
	// }
	//
	// tweets = tweets.substring(tweets.indexOf("ENDTWEET") + 8);
	//
	// }
	// writer.close();
	// }

}
