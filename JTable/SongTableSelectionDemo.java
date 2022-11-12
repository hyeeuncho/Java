public class SongTableSelectionDemo extends JPanel
				implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    JTable table = null;
    JTextField edits[] = new JTextField[5];
    
    SongMgr mgr = new SongMgr();
	
    public SongTableSelectionDemo() {
    	super(new BorderLayout());
    	songTableInit();
    	JPanel pane = makeBottomPane();
        add(pane, BorderLayout.PAGE_END);
    }
    void songTableInit() {
     	mgr.readAll("songs.txt");
     	
        final String[] columnNames = {"랭킹", "이름", "제목", "년도", "가사"};
    	DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
    	for (Song s : SongMgr.songs)
    		tableModel.addRow(s.getTexts());
    	
       	table = new JTable(tableModel);
        table.setPreferredScrollableViewportSize(new Dimension(500, 220));
        table.setFillsViewportHeight(true);
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        ListSelectionModel rowSM = table.getSelectionModel();
        rowSM.addListSelectionListener(this);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);    	
    }
    JPanel makeBottomPane() {
    	JPanel pane = new JPanel();
    	pane.setLayout(new GridLayout(2, 1));

    	JPanel center = new JPanel();
        center.setLayout(new FlowLayout());      
        for (int i = 0; i < 5; i++) {
        	edits[i] = new JTextField("", 10);
        	center.add(edits[i]);
        }
        JButton editBtn = new JButton("저장");
        editBtn.setActionCommand("Done");
    	editBtn.addActionListener(this);
    	center.add(editBtn);
        pane.add(center);
        
        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout());
        JButton buttons[] = new JButton[2];
        String btnTexts[] = {"추가", "삭제"};
        for (int i = 0; i < 2; i++) {
        	buttons[i] = new JButton(btnTexts[i]);
        	buttons[i].addActionListener(this);
        	bottom.add(buttons[i]);
        }
        pane.add(bottom);
        return pane;
    }
    int selectedIndex = -1;
    public void valueChanged(ListSelectionEvent e) {
        ListSelectionModel lsm = (ListSelectionModel)e.getSource();
        if (!lsm.isSelectionEmpty()) {
        	selectedIndex = lsm.getMinSelectionIndex();
            moveSelectedToEdits();
        }
    }
    public void actionPerformed(ActionEvent e) {
    	DefaultTableModel data = (DefaultTableModel)(table.getModel());
    	if (e.getActionCommand().equals("Done")) {

    	} else if (e.getActionCommand().equals("추가")) {

    	} else if (e.getActionCommand().equals("삭제")) {

    	}
    }
}