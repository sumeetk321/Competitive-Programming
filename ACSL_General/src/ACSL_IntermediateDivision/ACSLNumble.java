package ACSL_IntermediateDivision;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ACSLNumble {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("NumbleI1.txt");
		Scanner scan = new Scanner(file);

		String[] nums = scan.nextLine().split(", ");
		int[] num1 = new int[7], num2 = new int[7];
		for (int i = 0; i < 7; i++) {
			num1[i] = Character.getNumericValue(nums[0].charAt(i));
			num2[i] = Character.getNumericValue(nums[1].charAt(i));
		}
		Arrays.sort(num1);
		int[] num01 = new int[7];
		int j = 0;
		for (int i = 6; i > -1; i--) {
			num01[i] = num1[j];
			j++;
		}
		num1 = num01;
		Arrays.sort(num2);
		int[] num02 = new int[7];
		int k = 0;
		for (int i = 6; i > -1; i--) {
			num02[i] = num2[k];
			k++;
		}
		num2 = num02;

		for (int i = 0; i < 5; i++) {
			String[] in = scan.nextLine().split(", ");
			int length1 = Integer.parseInt(in[0]);
			int length2 = Integer.parseInt(in[1]);
			int crossing = Integer.parseInt(in[2]);
			num01 = new int[length1];
			num02 = new int[length2];
			for (int l = 0; l < length1; l++) {
				num01[l] = num1[l];
			}
			for (int l = 0; l < length2; l++) {
				num02[l] = num2[l];
			}
			ArrayList<Integer> trans1 = new ArrayList<Integer>();
			for (int l = 0; l < 7; l++) {
				trans1.add(num1[l]);
			}

			int diff1 = 7 - length1;

			if (diff1 != 0) {
				mainloop: for (int a = 6; a > -1; a--) {

					if (diff1 > 1) {
						for (int b = 6; b > -1; b--) {
							if (diff1 > 2) {
								for (int c = 6; c > -1; c--) {

									if (diff1 > 3) {
										for (int d = 6; d > -1; d--) {
											if (diff1 > 4) {
												for (int e = 6; e > -1; e--) {
													if (diff1 > 5) {
														for (int f = 6; f > -1; f--) {
															if ((num1[a] + num1[b] + num1[c] + num1[d] + num1[e]
																	+ num1[f]) % 5 == 0 && a != b && a != c && a != d
																	&& a != e && a != f && b != c && b != d && b != e
																	&& b != f && c != d && c != e && c != f && d != e
																	&& d != f && num1[a] != crossing
																	&& num1[b] != crossing && num1[c] != crossing
																	&& num1[d] != crossing && num1[e] != crossing
																	&& num1[f] != crossing) {
																trans1.remove(a);
																trans1.remove(b);
																trans1.remove(c);
																trans1.remove(d);
																trans1.remove(e);
																trans1.remove(f);
																break mainloop;
															}
														}
													} else {
														if ((num1[a] + num1[b] + num1[c] + num1[d] + num1[e]) % 5 == 0
																&& a != b && a != c && a != d && a != e && b != c
																&& b != d && b != e && c != d && c != e && d != e
																&& num1[a] != crossing && num1[b] != crossing
																&& num1[c] != crossing && num1[d] != crossing
																&& num1[e] != crossing) {

															trans1.remove(a);
															trans1.remove(b);
															trans1.remove(c);
															trans1.remove(d);
															trans1.remove(e);
															break mainloop;
														}
													}
												}
											} else {
												if ((num1[a] + num1[b] + num1[c] + num1[d]) % 5 == 0 && a != b && a != c
														&& a != d && b != c && b != d && c != d && num1[a] != crossing
														&& num1[b] != crossing && num1[c] != crossing
														&& num1[d] != crossing) {
													trans1.remove(a);
													trans1.remove(b);
													trans1.remove(c);
													trans1.remove(d);
													break mainloop;
												}
											}
										}
									} else {
										if ((num1[a] + num1[b] + num1[c]) % 5 == 0 && a != b && a != c && b != c
												&& num1[a] != crossing && num1[b] != crossing && num1[c] != crossing) {
											trans1.remove(a);
											trans1.remove(b);
											trans1.remove(c);
											break mainloop;
										}
									}
								}
							} else {
								if ((num1[a] + num1[b]) % 5 == 0 && a != b && num1[a] != crossing
										&& num1[b] != crossing) {
									trans1.remove(a);
									trans1.remove(b);
									break mainloop;
								}
							}

						}
					} else {
						if (num1[a] % 5 == 0 && num1[a] != crossing) {
							trans1.remove(a);
							break mainloop;
						}
					}
				}
			}
			ArrayList<Integer> trans2 = new ArrayList<Integer>();
			for (int l = 0; l < 7; l++) {
				trans2.add(num2[l]);
			}
			int diff2 = 7 - length2;

			if (diff2 != 0) {
				mainloop: for (int a = 6; a > -1; a--) {

					if (diff2 > 1) {
						for (int b = 6; b > -1; b--) {
							if (diff2 > 2) {
								for (int c = 6; c > -1; c--) {

									if (diff2 > 3) {
										for (int d = 6; d > -1; d--) {
											if (diff2 > 4) {
												for (int e = 6; e > -1; e--) {
													if (diff2 > 5) {
														for (int f = 6; f > -1; f--) {
															if ((num2[a] + num2[b] + num2[c] + num2[d] + num2[e]
																	+ num2[f]) % 5 == 0 && a != b && a != c && a != d
																	&& a != e && a != f && b != c && b != d && b != e
																	&& b != f && c != d && c != e && c != f && d != e
																	&& d != f && num2[a] != crossing
																	&& num2[b] != crossing && num2[c] != crossing
																	&& num2[d] != crossing && num2[e] != crossing
																	&& num2[f] != crossing) {
																trans2.remove(a);
																trans2.remove(b);
																trans2.remove(c);
																trans2.remove(d);
																trans2.remove(e);
																trans2.remove(f);
																break mainloop;
															}
														}
													} else {
														if ((num2[a] + num2[b] + num2[c] + num2[d] + num2[e]) % 5 == 0
																&& a != b && a != c && a != d && a != e && b != c
																&& b != d && b != e && c != d && c != e && d != e
																&& num2[a] != crossing && num2[b] != crossing
																&& num2[c] != crossing && num2[d] != crossing
																&& num2[e] != crossing) {

															trans2.remove(a);
															trans2.remove(b);
															trans2.remove(c);
															trans2.remove(d);
															trans2.remove(e);
															break mainloop;
														}
													}
												}
											} else {
												if ((num2[a] + num2[b] + num2[c] + num2[d]) % 5 == 0 && a != b && a != c
														&& a != d && b != c && b != d && c != d && num2[a] != crossing
														&& num2[b] != crossing && num2[c] != crossing
														&& num2[d] != crossing) {
													trans2.remove(a);
													trans2.remove(b);
													trans2.remove(c);
													trans2.remove(d);
													break mainloop;
												}
											}
										}
									} else {
										if ((num2[a] + num2[b] + num2[c]) % 5 == 0 && a != b && a != c && b != c
												&& num2[a] != crossing && num2[b] != crossing && num2[c] != crossing) {
											trans2.remove(a);
											trans2.remove(b);
											trans2.remove(c);
											break mainloop;
										}
									}
								}
							} else {
								if ((num2[a] + num2[b]) % 5 == 0 && a != b && num2[a] != crossing
										&& num2[b] != crossing) {
									trans2.remove(a);
									trans2.remove(b);
									break mainloop;
								}
							}

						}
					} else {
						if (num2[a] % 5 == 0 && num2[a] != crossing) {
							trans2.remove(a);
							break mainloop;
						}
					}
				}
			}

			String[][] grid = new String[length2][length1];
			for (int l = 0; l < length2; l++) {
				for (int m = 0; m < length1; m++) {
					grid[l][m] = " ";
				}
			}
			for (int l = 0; l < length1; l++) {
				grid[trans2.indexOf(crossing)][l] = trans1.get(l) + "";
			}
			for (int l = 0; l < length2; l++) {
				grid[l][trans1.indexOf(crossing)] = trans2.get(l) + "";
			}

			for (int l = 0; l < length2; l++) {
				for (int m = 0; m < length1; m++) {
					System.out.print(grid[l][m]);
				}
				System.out.println("\n");

			}
			System.out.println("\n");
			System.out.println("\n");
		}

	}

}
