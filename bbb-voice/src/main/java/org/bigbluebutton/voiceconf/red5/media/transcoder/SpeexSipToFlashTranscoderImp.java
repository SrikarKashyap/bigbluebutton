/*
 * BigBlueButton - http://www.bigbluebutton.org
 * 
 * Copyright (c) 2008-2009 by respective authors (see below). All rights reserved.
 * 
 * BigBlueButton is free software; you can redistribute it and/or modify it under the 
 * terms of the GNU Lesser General Public License as published by the Free Software 
 * Foundation; either version 3 of the License, or (at your option) any later 
 * version. 
 * 
 * BigBlueButton is distributed in the hope that it will be useful, but WITHOUT ANY 
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A 
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public License along 
 * with BigBlueButton; if not, If not, see <http://www.gnu.org/licenses/>.
 *
 * $Id: $
 */
package org.bigbluebutton.voiceconf.red5.media.transcoder;

import org.red5.app.sip.codecs.Codec;
import org.red5.logging.Red5LoggerFactory;
import org.slf4j.Logger;

public class SpeexSipToFlashTranscoderImp implements SipToFlashTranscoder {
	protected static Logger log = Red5LoggerFactory.getLogger(SpeexSipToFlashTranscoderImp.class, "sip");
	
	private static final int SPEEX_CODEC = 178; /* 1011 1111 (see flv spec) */
	private Codec audioCodec = null;
	
	public SpeexSipToFlashTranscoderImp(Codec codec) {
		this.audioCodec = codec;
	}

	@Override
	public void transcode(byte[] codedBuffer, TranscodedAudioDataListener listener) {
		listener.handleTranscodedAudioData(codedBuffer);
	}
	
	@Override
	public int getCodecId() {
		return SPEEX_CODEC;
	}

	@Override
	public int getIncomingEncodedFrameSize() {
		return audioCodec.getIncomingEncodedFrameSize();
	}


}
