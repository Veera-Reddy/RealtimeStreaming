package spark;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.swing.JOptionPane;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

/**
 *
 * @author Veera
 */
public class PostTweet extends javax.swing.JFrame {

    /**
     * Creates new form PostTweet
     */
    public PostTweet() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        top_Jpanel = new javax.swing.JPanel();
        title_label = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tweetArea = new javax.swing.JTextArea();
        PostTweet = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Posting Tweet");
        setBackground(new java.awt.Color(255, 165, 0));
        //setBackground(new java.awt.Color(255, 255, 255));
        setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        setResizable(false);

        top_Jpanel.setBackground(new java.awt.Color(157, 225, 254));
        top_Jpanel.setForeground(new java.awt.Color(157, 225, 254));

        title_label.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        title_label.setForeground(new java.awt.Color(13, 142, 115));
        title_label.setText("Post a Tweet to Twitter");

        javax.swing.GroupLayout top_JpanelLayout = new javax.swing.GroupLayout(top_Jpanel);
        top_Jpanel.setLayout(top_JpanelLayout);
        top_JpanelLayout.setHorizontalGroup(
            top_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(top_JpanelLayout.createSequentialGroup()
                .addGap(292, 292, 292)
                .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        top_JpanelLayout.setVerticalGroup(
            top_JpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, top_JpanelLayout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(title_label, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        tweetArea.setColumns(20);
        tweetArea.setRows(5);
        jScrollPane1.setViewportView(tweetArea);

        PostTweet.setText("Post Tweet");
        PostTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PostTweetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(top_Jpanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(355, 355, 355)
                        .addComponent(PostTweet)))
                .addContainerGap(275, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(top_Jpanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(PostTweet)
                .addGap(0, 196, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(833, 547));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void PostTweetActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	Authenticate();
    	String tweet = tweetArea.getText();
		Twitter twitter = TwitterFactory.getSingleton();
	    try {
			@SuppressWarnings("unused")
			Status status = twitter.updateStatus(tweet);
		} catch (TwitterException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Your tweet was not sent.");
		}
	    //System.out.println("Successfully updated the status to [" + status.getText() + "].");
		JOptionPane.showMessageDialog(null, "Your Tweet was sent to your TimeLine");
    }                                         

    public static void Authenticate() {
    	System.setProperty("twitter4j.oauth.consumerKey", "06VbUtXmxCIycXgEJy6F2ZqeJ");
		System.setProperty("twitter4j.oauth.consumerSecret", "R1OHvmRcKELyHBDLnGca1QOW1tAR2SgtGkkqhOi2KySeCexFOa");
		System.setProperty("twitter4j.oauth.accessToken", "925004856-ewsJKUawywszTXpHfA76XvYgOJWgIeR8jBBY77Aa");
		System.setProperty("twitter4j.oauth.accessTokenSecret", "pufuk7ZoQHSE8WIzDdIRdwzB3Hdp6KlTZwlHgXVkr34Xd");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PostTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PostTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PostTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PostTweet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PostTweet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton PostTweet;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel title_label;
    private javax.swing.JPanel top_Jpanel;
    private javax.swing.JTextArea tweetArea;
    // End of variables declaration                   
}
                      



