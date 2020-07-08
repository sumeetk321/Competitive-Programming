/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

/*
 * MainForm.java
 *
 * Created on 5 Aug, 2010, 5:46:53 PM
 */

//package tictacktoe;

import com.sun.awt.AWTUtilities;
import java.awt.Color;
import java.awt.Component;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author tej
 */
public class NaughtsAndCrosses extends javax.swing.JFrame {
static boolean visited = false;
	/** Creates new form MainForm */
	public NaughtsAndCrosses() {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
		}
		initComponents();
		// AWTUtilities.setWindowOpacity(this,(float)0.90);
		this.getContentPane().setBackground(Color.DARK_GRAY);
		reset();
	}

	// 2D array of the grid
	int[][] pos = new int[3][3];
	int cnt, val, a, b, c = 1, d = 1, diff = 1, vs = 1;
	char let;
	String pl1 = "You", pl2 = "Computer";
	Random rnd = new Random();
	boolean turn = true;

	void reset() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				pos[i][j] = 0;
			}
		}
		Component[] cmpnt = this.getContentPane().getComponents();
		for (int i = 0; i < cmpnt.length; i++) {
			if (cmpnt[i] instanceof JLabel) {
				((JLabel) cmpnt[i]).setText("");
			}
		}
		cnt = 0;
		let = 'X';
		val = 1;
	}

	boolean play(int l, int m) {
		if(!visited && turn){
		compplay(val);
		}
		if (pos[l][m] == 0) {
			a = c;
			b = d;
			c = l;
			d = m;
			JLabel ctrl = link(l, m);
			ctrl.setText(String.valueOf(let));
			pos[l][m] = val;
			flip();
			checkwin(l, m, pos[l][m]);
			return true;
		} else
			return false;
	}

	JLabel link(int l, int m) {
		if (l == 0 && m == 0) {
			return jLabel1;
		} else if (l == 0 && m == 1) {
			return jLabel2;
		} else if (l == 0 && m == 2) {
			return jLabel3;
		} else if (l == 1 && m == 0) {
			return jLabel6;
		} else if (l == 1 && m == 1) {
			return jLabel5;
		} else if (l == 1 && m == 2) {
			return jLabel4;
		} else if (l == 2 && m == 0) {
			return jLabel9;
		} else if (l == 2 && m == 1) {
			return jLabel8;
		} else if (l == 2 && m == 2) {
			return jLabel7;
		}
		return null;
	}

	void flip() {
		if (let == 'X') {
			let = 'O';
		} else
			let = 'X';

		if (val == 1) {
			val = 4;
		} else
			val = 1;
		cnt++;
	}

	void checkwin(int l, int m, int n) {
		if (cnt == 1)
			if (vs == 1)
				turn = true;
		if (cnt > 4) {

			if (pos[0][0] == pos[1][0] && pos[0][0] == pos[2][0]) {
				if (pos[0][0] == 1)
					declare("X wins!");
				if (pos[0][0] == 4)
					declare("O wins!");
			} else if (pos[0][1] == pos[1][1] && pos[0][1] == pos[2][1]) {
				if (pos[0][1] == 1)
					declare("X wins!");
				if (pos[0][1] == 4)
					declare("O wins!");
			} else if (pos[0][2] == pos[1][2] && pos[0][2] == pos[2][2]) {
				if (pos[0][2] == 1)
					declare("X wins!");
				if (pos[0][2] == 4)
					declare("O wins!");
			} else if (pos[0][0] == pos[0][1] && pos[0][0] == pos[0][2]) {
				if (pos[0][0] == 1)
					declare("X wins!");
				if (pos[0][0] == 4)
					declare("O wins!");
			} else if (pos[1][0] == pos[1][1] && pos[1][0] == pos[1][2]) {
				if (pos[1][0] == 1)
					declare("X wins!");
				if (pos[1][0] == 4)
					declare("O wins!");
			} else if (pos[2][0] == pos[2][1] && pos[2][0] == pos[2][2]) {
				if (pos[2][0] == 1)
					declare("X wins!");
				if (pos[2][0] == 4)
					declare("O wins!");
			} else if (pos[0][0] == pos[1][1] && pos[0][0] == pos[2][2]) {
				if (pos[0][0] == 1)
					declare("X wins!");
				if (pos[0][0] == 4)
					declare("O wins!");
			} else if (pos[0][2] == pos[1][1] && pos[0][2] == pos[2][0]) {
				if (pos[0][2] == 1)
					declare("X wins!");		
				if (pos[0][2] == 4)
					declare("O wins!");
			} else {
				boolean ok = true;
				for (int i = 0; i < 3; i++) {
					for (int j = 0; j < 3; j++) {
						if (pos[i][j] == 0)
							ok = false;
					}
				}
				if (ok) {
					declare("TIE!");
				}
			}

		}
	}

	void declare(String stmt) {
		if (JOptionPane.showConfirmDialog(this, stmt + " Do you want to continue?", "", 0) != 0) {
			System.exit(0);
		} else {
			reset();
			
		}
	}

	void compplay(int n) {
		visited = true;
		boolean carry = true;
		if (diff == 3)
			winorstop(a, b, n);
			if ((diff == 2 || diff == 3) && carry) {
				winorstop(a, b, n);
			}
		if (carry) {
			doany();
		}
	}

	boolean winorstop(int l, int m, int n) {
		if (pos[l][0] + pos[l][1] + pos[l][2] == n * 2) {
			for (int i = 0; i < 3; i++) {
				if (play(l, i))
					return false;
			}
		} else if (pos[0][m] + pos[1][m] + pos[2][m] == n * 2) {
			for (int i = 0; i < 3; i++) {
				if (play(i, m))
					return false;
			}
		} else if (pos[0][0] + pos[1][1] + pos[2][2] == n * 2) {
			for (int i = 0; i < 3; i++) {
				if (play(i, i))
					return false;
			}
		} else if (pos[2][0] + pos[1][1] + pos[0][2] == n * 2) {
			for (int i = 0, j = 2; i < 3; i++, j--) {
				if (play(i, j))
					return false;
			}
		}

		return true;
	}
	/*void winorstop(){
		if (pos[0][0] == pos[1][0] || pos[0][0] == pos[2][0] || pos[1][0]==pos[2][0]) {
			
		} else if (pos[0][1] == pos[1][1] || pos[0][1] == pos[2][1]) {
			
		} else if (pos[0][2] == pos[1][2] || pos[0][2] == pos[2][2]) {
			
		} else if (pos[0][0] == pos[0][1] || pos[0][0] == pos[0][2]) {
			
		} else if (pos[1][0] == pos[1][1] || pos[1][0] == pos[1][2]) {
			
		} else if (pos[2][0] == pos[2][1] || pos[2][0] == pos[2][2]) {
			
		} else if (pos[0][0] == pos[1][1] || pos[0][0] == pos[2][2]) {
			
		} else if (pos[0][2] == pos[1][1] || pos[0][2] == pos[2][0]) {
			
		} else {
			boolean ok = true;
			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					if (pos[i][j] == 0)
						ok = false;
				}
			}
			if (ok) {
				declare("TIE!");
			}
		}

	}*/

	void doany() {
		int l = 2, m = 0;
		switch (cnt) {
		case 0:
			play(0, 0);
			break;
		case 1:
			if (!(play(1, 1)))
				play(0, 0);
			break;
		case 2:
			if (!(play(2, 2)))
				play(0, 2);
			break;
		case 3:
			if ((pos[0][1] + pos[1][1] + pos[2][1]) == val)
				play(0, 1);
			else if ((pos[1][0] + pos[1][1] + pos[1][2]) == val)
				play(1, 0);
			else if (pos[0][1] != 0)
				play(0, 2);
			else
				play(2, 0);

			break;
		default:
			while (!(play(l, m))) {
				l = rnd.nextInt(3);
				m = rnd.nextInt(3);
			}
			break;
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		buttonGroup1 = new javax.swing.ButtonGroup();
		buttonGroup2 = new javax.swing.ButtonGroup();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		label1 = new java.awt.Label();
		label2 = new java.awt.Label();
		label3 = new java.awt.Label();
		label4 = new java.awt.Label();
		jLabel10 = new javax.swing.JLabel();
		jMenuBar1 = new javax.swing.JMenuBar();
		jMenu1 = new javax.swing.JMenu();
		jMenuItem1 = new javax.swing.JMenuItem();
		jMenuItem2 = new javax.swing.JMenuItem();
		jMenu2 = new javax.swing.JMenu();
		jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
		jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
		jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
		jRadioButtonMenuItem3 = new javax.swing.JRadioButtonMenuItem();
		jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
		jMenu3 = new javax.swing.JMenu();
		jMenuItem3 = new javax.swing.JMenuItem();
		jMenuItem4 = new javax.swing.JMenuItem();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Tic Tac Toe");
		setBackground(java.awt.Color.darkGray);
		setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		setResizable(false);
		getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
		// getContentPane().setLayout(new java.awt.BorderLayout());

		jLabel1.setBackground(java.awt.Color.darkGray);
		jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel1.setForeground(java.awt.Color.white);
		jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel1.setOpaque(true);
		jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel1MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 68, 69));
		// getContentPane().add(jLabel1, new java.awt.BorderLayout(0, 1));

		jLabel2.setBackground(java.awt.Color.darkGray);
		jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel2.setForeground(java.awt.Color.white);
		jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel2.setOpaque(true);
		jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel2MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 68, 69));
		// getContentPane().add(jLabel2, new java.awt.BorderLayout(80, 1));

		jLabel3.setBackground(java.awt.Color.darkGray);
		jLabel3.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel3.setForeground(java.awt.Color.white);
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setOpaque(true);
		jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel3MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 68, 69));
		// getContentPane().add(jLabel3, new java.awt.BorderLayout(160, 1));

		jLabel4.setBackground(java.awt.Color.darkGray);
		jLabel4.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel4.setForeground(java.awt.Color.white);
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setOpaque(true);
		jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel4MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 68, 69));
		// getContentPane().add(jLabel4, new java.awt.BorderLayout(80, 1));

		jLabel5.setBackground(java.awt.Color.darkGray);
		jLabel5.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel5.setForeground(java.awt.Color.white);
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setOpaque(true);
		jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel5MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 68, 69));
		// getContentPane().add(jLabel5, new java.awt.BorderLayout(0, 1));

		jLabel6.setBackground(java.awt.Color.darkGray);
		jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel6.setForeground(java.awt.Color.white);
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setOpaque(true);
		jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel6MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 68, 69));
		// getContentPane().add(jLabel6, new java.awt.BorderLayout(80, 1));

		jLabel7.setBackground(java.awt.Color.darkGray);
		jLabel7.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel7.setForeground(java.awt.Color.white);
		jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel7.setOpaque(true);
		jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel7MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 68, 69));
		// getContentPane().add(jLabel7, new java.awt.BorderLayout(0, 1));

		jLabel8.setBackground(java.awt.Color.darkGray);
		jLabel8.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel8.setForeground(java.awt.Color.white);
		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel8.setOpaque(true);
		jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel8MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 68, 69));
		// getContentPane().add(jLabel8, new java.awt.BorderLayout(80, 1));

		jLabel9.setBackground(java.awt.Color.darkGray);
		jLabel9.setFont(new java.awt.Font("Comic Sans MS", 1, 60));
		jLabel9.setForeground(java.awt.Color.white);
		jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel9.setOpaque(true);
		jLabel9.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				jLabel9MouseClicked(evt);
			}
		});
		getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 68, 69));
		// getContentPane().add(jLabel9, new java.awt.BorderLayout(160, 1));

		label1.setBackground(java.awt.Color.white);
		getContentPane().add(label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 161, 228, 6));
		// getContentPane().add(label1, new java.awt.BorderLayout(151, 222));

		label2.setBackground(java.awt.Color.white);
		getContentPane().add(label2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 81, 228, 6));
		// getContentPane().add(label2, new java.awt.BorderLayout(71, 222));

		label3.setBackground(java.awt.Color.white);
		getContentPane().add(label3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 10, 6, 230));
		// getContentPane().add(label3, new java.awt.BorderLayout(151, 224));

		label4.setBackground(java.awt.Color.white);
		getContentPane().add(label4, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 10, 6, 230));
		// getContentPane().add(label4, new java.awt.BorderLayout(71, 224));

		jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel10.setText("Player 1 to play First");
		jLabel10.setOpaque(true);
		getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 250, 250, 18));
		// getContentPane().add(jLabel10, new java.awt.BorderLayout(250, 232));

		jMenuBar1.setBackground(java.awt.Color.darkGray);
		jMenuBar1.setBorder(null);
		jMenuBar1.setForeground(java.awt.Color.white);
		jMenuBar1.setFocusable(false);
		jMenuBar1.setOpaque(false);

		jMenu1.setText("Game");

		jMenuItem1.setText("New Game");
		jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem1ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem1);

		jMenuItem2.setText("Exit");
		jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem2ActionPerformed(evt);
			}
		});
		jMenu1.add(jMenuItem2);

		jMenuBar1.add(jMenu1);

		jMenu2.setText("Options");

		buttonGroup1.add(jCheckBoxMenuItem1);
		jCheckBoxMenuItem1.setSelected(true);
		jCheckBoxMenuItem1.setText("Vs Computer");
		jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBoxMenuItem1ActionPerformed(evt);
			}
		});
		jMenu2.add(jCheckBoxMenuItem1);

		buttonGroup2.add(jRadioButtonMenuItem1);
		jRadioButtonMenuItem1.setSelected(true);
		jRadioButtonMenuItem1.setText("Easy");
		jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonMenuItem1ActionPerformed(evt);
			}
		});
		jMenu2.add(jRadioButtonMenuItem1);

		buttonGroup2.add(jRadioButtonMenuItem2);
		jRadioButtonMenuItem2.setText("Medium");
		jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonMenuItem2ActionPerformed(evt);
			}
		});
		jMenu2.add(jRadioButtonMenuItem2);

		buttonGroup2.add(jRadioButtonMenuItem3);
		jRadioButtonMenuItem3.setText("Hard");
		jRadioButtonMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jRadioButtonMenuItem3ActionPerformed(evt);
			}
		});
		jMenu2.add(jRadioButtonMenuItem3);

		buttonGroup1.add(jCheckBoxMenuItem2);
		jCheckBoxMenuItem2.setText("Vs Player");
		jCheckBoxMenuItem2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jCheckBoxMenuItem2ActionPerformed(evt);
			}
		});
		jMenu2.add(jCheckBoxMenuItem2);

		jMenuBar1.add(jMenu2);

		jMenu3.setText("Help");

		jMenuItem3.setText("How to Play");
		jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem3ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem3);

		jMenuItem4.setText("About");
		jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jMenuItem4ActionPerformed(evt);
			}
		});
		jMenu3.add(jMenuItem4);

		jMenuBar1.add(jMenu3);

		setJMenuBar(jMenuBar1);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel1MouseClicked
		if (play(0, 0) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel1MouseClicked

	private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel2MouseClicked
		if (play(0, 1) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel2MouseClicked

	private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel3MouseClicked
		if (play(0, 2) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel3MouseClicked

	private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel6MouseClicked
		if (play(1, 0) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel6MouseClicked

	private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel5MouseClicked
		if (play(1, 1) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel5MouseClicked

	private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel4MouseClicked
		if (play(1, 2) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel4MouseClicked

	private void jLabel9MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel9MouseClicked
		if (play(2, 0) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel9MouseClicked

	private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel8MouseClicked
		if (play(2, 1) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel8MouseClicked

	private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jLabel7MouseClicked
		if (play(2, 2) && turn == true)
			compplay(val);
	}// GEN-LAST:event_jLabel7MouseClicked

	private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
		diff = 1;
	}// GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

	private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
		diff = 2;
	}// GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

	private void jRadioButtonMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jRadioButtonMenuItem3ActionPerformed
		diff = 3;
	}// GEN-LAST:event_jRadioButtonMenuItem3ActionPerformed

	private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
		pl1 = "You";
		pl2 = "Computer";
		reset();
		vs = 1;
	}// GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

	private void jCheckBoxMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jCheckBoxMenuItem2ActionPerformed
		pl1 = "Player 1";
		pl2 = "Player 2";
		reset();
		vs = 2;
		turn = false;

	}// GEN-LAST:event_jCheckBoxMenuItem2ActionPerformed

	private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem1ActionPerformed
		if (vs == 1) {
			pl1 = "You";
			pl2 = "Computer";
		} else {
			pl1 = "Player 1";
			pl2 = "Player 2";
		}
		reset();
	}// GEN-LAST:event_jMenuItem1ActionPerformed

	private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem2ActionPerformed
		System.exit(0);
	}// GEN-LAST:event_jMenuItem2ActionPerformed

	private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem3ActionPerformed
		JOptionPane.showMessageDialog(this,
				"This is a  simple game  in which  Win  is achieved whennthree consecutive blocks in a Row, Column or Diagonalnare occupied before the opponent does the same.");
	}// GEN-LAST:event_jMenuItem3ActionPerformed

	private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jMenuItem4ActionPerformed
		JOptionPane.showMessageDialog(this, "Developer: Tejas Pathakndevtejaspathak@gmail.com");
	}// GEN-LAST:event_jMenuItem4ActionPerformed

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new NaughtsAndCrosses().setVisible(true);
			}
		});

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup buttonGroup1;
	private javax.swing.ButtonGroup buttonGroup2;
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
	private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JMenu jMenu1;
	private javax.swing.JMenu jMenu2;
	private javax.swing.JMenu jMenu3;
	private javax.swing.JMenuBar jMenuBar1;
	private javax.swing.JMenuItem jMenuItem1;
	private javax.swing.JMenuItem jMenuItem2;
	private javax.swing.JMenuItem jMenuItem3;
	private javax.swing.JMenuItem jMenuItem4;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
	private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem3;
	private java.awt.Label label1;
	private java.awt.Label label2;
	private java.awt.Label label3;
	private java.awt.Label label4;
	// End of variables declaration//GEN-END:variables

}
