package com.chenlb.mmseg4j;


public class SimpleSeg extends Seg{
	
	public SimpleSeg(Dictionary dic) {
		super(dic);
	}

	public Chunk seg(Sentence sen) {
		Chunk chunk = new Chunk();
		char[] chs = sen.getText();
		for(int k=0; k<3&&!sen.isFinish(); k++) {
			int offset = sen.getOffset();
			int maxLen = 0;

			maxLen = dic.maxMatch(chs, offset);
			
			chunk.words[k] = new Word(chs, sen.getStartOffset(), offset, maxLen+1);

			offset += maxLen + 1;
			sen.setOffset(offset);
		}
		
		return chunk;
	}
}
