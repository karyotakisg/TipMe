else if (e.getSource() == like && like.getBackground() == Color.white && flagCounter == 2 ) {
					int input = JOptionPane.showOptionDialog(null, "Remove your dislike first (click again on the dislike button)", 
							null, null, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
				}
				else  {
					int input = JOptionPane.showOptionDialog(null, "Remove your like first (click again on the like button)", 
							null, null, JOptionPane.INFORMATION_MESSAGE, null, null, null);
				
				}