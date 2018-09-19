package spark;

public class UI extends javax.swing.JFrame {

    /**
     * Creates new form HashTags
     */
    public UI() {
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

        mainPanel = new javax.swing.JPanel();
        heading = new javax.swing.JLabel();
        tweets = new javax.swing.JButton();
        hashTags = new javax.swing.JButton();
        stats = new javax.swing.JButton();
        postTweet = new javax.swing.JButton();
        sidebar_left = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Realtime Streaming Using Spark");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(255, 165, 0));
        setForeground(java.awt.Color.orange);
        setName("Realtime streaming using Spark"); // NOI18N
        setResizable(false);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        heading.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        heading.setForeground(new java.awt.Color(2, 102, 24));
        heading.setText("   Streaming Type");

        tweets.setForeground(new java.awt.Color(255, 12, 26));
        tweets.setText("Tweets");
        tweets.setToolTipText("");
        tweets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tweetsActionPerformed(evt);
            }
        });

        hashTags.setForeground(new java.awt.Color(255, 12, 26));
        hashTags.setText("Hash Tags");
        hashTags.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hashTagsActionPerformed(evt);
            }
        });

        stats.setForeground(new java.awt.Color(255, 12, 26));
        stats.setText("    stats  ");
        stats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statsActionPerformed(evt);
            }
        });

        postTweet.setForeground(new java.awt.Color(255, 12, 26));
        postTweet.setText("Post Tweet");
        postTweet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                postTweetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap(105, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stats)
                    .addComponent(tweets))
                .addGap(109, 109, 109)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hashTags)
                    .addComponent(postTweet))
                .addGap(220, 220, 220))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(heading, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tweets)
                    .addComponent(hashTags))
                .addGap(59, 59, 59)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stats)
                    .addComponent(postTweet))
                .addContainerGap(169, Short.MAX_VALUE))
        );

        heading.getAccessibleContext().setAccessibleDescription("");

        sidebar_left.setBackground(new java.awt.Color(255, 165, 0));

        javax.swing.GroupLayout sidebar_leftLayout = new javax.swing.GroupLayout(sidebar_left);
        sidebar_left.setLayout(sidebar_leftLayout);
        sidebar_leftLayout.setHorizontalGroup(
            sidebar_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        sidebar_leftLayout.setVerticalGroup(
            sidebar_leftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(sidebar_left, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(sidebar_left, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(741, 468));
        setLocationRelativeTo(null);
    }// </editor-fold>                        

    private void tweetsActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
    	TweetsConsole.main(new String[] {});
    }                                      

    private void hashTagsActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        HashTagConsole.main(new String[] {});
    }                                        

    private void statsActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
    	Twitterstats.main(new String[] {});
    }                                     

    private void postTweetActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // TODO add your handling code here:
    	PostTweet.main(new String[] {});
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
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton hashTags;
    private javax.swing.JLabel heading;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton postTweet;
    private javax.swing.JPanel sidebar_left;
    private javax.swing.JButton stats;
    private javax.swing.JButton tweets;
    // End of variables declaration                   
}
