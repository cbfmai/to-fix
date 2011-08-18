package org.tomac.protocol.fix.messaging.fix50sp2;

// DO NOT EDIT!!!
// This file is generated by FixMessageGenerator.
// If you need additional functionality, put it in a helper class
// that does not live in this folder!!!  Any java file in this folder 
// will be deleted upon the next run of the FixMessageGenerator!

import java.nio.ByteBuffer;

import org.tomac.protocol.fix.FixUtils;
import org.tomac.protocol.fix.FixSessionException;
import org.tomac.protocol.fix.FixGarbledException;
import org.tomac.utils.Utils;
import org.tomac.protocol.fix.FixConstants;


import org.tomac.protocol.fix.messaging.fix50sp2.component.FixHopGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixApplicationSequenceControl;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixNewsRefGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixRoutingGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixLinesOfTextGrp;

public class FixNews extends FixMessage
{

	public byte[] newsID;
	public long newsCategory = 0;
	public byte[] languageCode;
	public FixApplicationSequenceControl applicationSequenceControl;
	public FixNewsRefGrp newsRefGrp;
	public byte[] origTime;
	public byte urgency = (byte)' ';
	public byte[] headline;
	public long encodedHeadlineLen = 0;
	public byte[] encodedHeadline;
	public FixRoutingGrp routingGrp;
	public byte[] marketID;
	public byte[] marketSegmentID;
	public FixInstrmtGrp instrmtGrp;
	public FixInstrmtLegGrp instrmtLegGrp;
	public FixUndInstrmtGrp undInstrmtGrp;
	public FixLinesOfTextGrp linesOfTextGrp;
	public byte[] uRLLink;
	public long rawDataLength = 0;
	public byte[] rawData;

	public FixNews() {
		super();

		newsID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		languageCode = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		applicationSequenceControl = new FixApplicationSequenceControl();
		newsRefGrp = new FixNewsRefGrp();
		origTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		headline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		encodedHeadline = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		routingGrp = new FixRoutingGrp();
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrmtGrp = new FixInstrmtGrp();
		instrmtLegGrp = new FixInstrmtLegGrp();
		undInstrmtGrp = new FixUndInstrmtGrp();
		linesOfTextGrp = new FixLinesOfTextGrp();
		uRLLink = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		rawData = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.NEWS_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( newsID, (byte)0 );
		newsCategory = Long.MAX_VALUE;		
		Utils.fill( languageCode, (byte)0 );
		Utils.fill( origTime, (byte)0 );
		urgency = Byte.MAX_VALUE;		
		Utils.fill( headline, (byte)0 );
		encodedHeadlineLen = Long.MAX_VALUE;		
		Utils.fill( encodedHeadline, (byte)0 );
		Utils.fill( marketID, (byte)0 );
		Utils.fill( marketSegmentID, (byte)0 );
		Utils.fill( uRLLink, (byte)0 );
		rawDataLength = Long.MAX_VALUE;		
		Utils.fill( rawData, (byte)0 );
		applicationSequenceControl.clear();
		newsRefGrp.clear();
		routingGrp.clear();
		instrmtGrp.clear();
		instrmtLegGrp.clear();
		undInstrmtGrp.clear();
		linesOfTextGrp.clear();
	}

	@Override
	public void getAll() throws FixSessionException, FixGarbledException
	{

		int startTagPosition = buf.position();

		super.getAll();

		// assumption message is full otherwise decode would return null
		// so negative id means that we are at the end of the message
		int id;
		int lastTagPosition = buf.position();
		while ( ( id = FixUtils.getTagId( buf ) ) > 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.NEWSID_INT:
				newsID = FixUtils.getTagStringValue(value, newsID);
				break;

			case FixTags.NEWSCATEGORY_INT:
				newsCategory = FixUtils.getTagIntValue( value );
				if (!NewsCategory.isValid(newsCategory) ) throw new FixSessionException(buf, "Invalid enumerated value(" + newsCategory + ") for tag: " + id );
				break;

			case FixTags.LANGUAGECODE_INT:
				languageCode = FixUtils.getTagStringValue(value, languageCode);
				break;

			case FixTags.APPLID_INT:
				applicationSequenceControl.getAll(FixTags.APPLID_INT, value );
				break;

			case FixTags.NONEWSREFIDS_INT:
				newsRefGrp.noNewsRefIDs = FixUtils.getTagIntValue( value );
				newsRefGrp.getAll(newsRefGrp.noNewsRefIDs, value );
				break;

			case FixTags.ORIGTIME_INT:
				origTime = FixUtils.getTagStringValue(value, origTime);
				break;

			case FixTags.URGENCY_INT:
				urgency = FixUtils.getTagCharValue( value );
				if (!Urgency.isValid(urgency) ) throw new FixSessionException(buf, "Invalid enumerated value(" + urgency + ") for tag: " + id );
				break;

			case FixTags.HEADLINE_INT:
				headline = FixUtils.getTagStringValue(value, headline);
				break;

			case FixTags.ENCODEDHEADLINELEN_INT:
				encodedHeadlineLen = FixUtils.getTagIntValue( value );
				break;

			case FixTags.ENCODEDHEADLINE_INT:
				encodedHeadline = FixUtils.getTagStringValue(value, encodedHeadline);
				break;

			case FixTags.NOROUTINGIDS_INT:
				routingGrp.noRoutingIDs = FixUtils.getTagIntValue( value );
				routingGrp.getAll(routingGrp.noRoutingIDs, value );
				break;

			case FixTags.MARKETID_INT:
				marketID = FixUtils.getTagStringValue(value, marketID);
				break;

			case FixTags.MARKETSEGMENTID_INT:
				marketSegmentID = FixUtils.getTagStringValue(value, marketSegmentID);
				break;

			case FixTags.NORELATEDSYM_INT:
				instrmtGrp.noRelatedSym = FixUtils.getTagIntValue( value );
				instrmtGrp.getAll(instrmtGrp.noRelatedSym, value );
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.NOLINESOFTEXT_INT:
				linesOfTextGrp.noLinesOfText = FixUtils.getTagIntValue( value );
				linesOfTextGrp.getAll(linesOfTextGrp.noLinesOfText, value );
				break;

			case FixTags.URLLINK_INT:
				uRLLink = FixUtils.getTagStringValue(value, uRLLink);
				break;

			case FixTags.RAWDATALENGTH_INT:
				rawDataLength = FixUtils.getTagIntValue( value );
				break;

			case FixTags.RAWDATA_INT:
				rawData = FixUtils.getTagStringValue(value, rawData);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(buf, "Required tag missing: " + id );

				return;

			default:
				throw new FixSessionException(buf, "Unknown tag: " + id );

			}

			lastTagPosition = buf.position();

		}

		buf.position(startTagPosition);

	}

	private int checkRequiredTags() {
		int tag = -1;

		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(headline) ) return FixTags.HEADLINE_INT;
		if (! linesOfTextGrp.isSet() ) return FixTags.NOLINESOFTEXT_INT;
		if (! FixUtils.isSet(checkSum) ) return FixTags.CHECKSUM_INT;
		return tag;

	}
	@Override
	public void encode( ByteBuffer out )
	{
		// Encode message. Set msgSeqNum and sendingTime and optional resend flags, before encoding. 

		int msgStart = out.position();

		out.put( BEGINSTRING_VALUE_WITH_TAG );

		int msgLengthValueStart = out.position() + 2 /* 9= */;

		// placeholder
		FixUtils.putFixTag(out, FixTags.BODYLENGTH_INT, FixConstants.MAX_MESSAGE_SIZE );

		int msgTypeStart = out.position();

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.NEWS);

		// encode all fields including the header

		if (FixUtils.isSet(applVerID)) FixUtils.putFixTag( out, FixTags.APPLVERID_INT, applVerID, 0, Utils.lastIndexTrim(applVerID, (byte)0) );
		if (FixUtils.isSet(cstmApplVerID)) FixUtils.putFixTag( out, FixTags.CSTMAPPLVERID_INT, cstmApplVerID, 0, Utils.lastIndexTrim(cstmApplVerID, (byte)0) );
		if (FixUtils.isSet(applExtID)) FixUtils.putFixTag( out, FixTags.APPLEXTID_INT, applExtID);
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(secureDataLen)) FixUtils.putFixTag( out, FixTags.SECUREDATALEN_INT, secureDataLen);
		if (FixUtils.isSet(secureData)) FixUtils.putFixTag( out, FixTags.SECUREDATA_INT, secureData, 0, Utils.lastIndexTrim(secureData, (byte)0) );
		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		if (FixUtils.isSet(senderLocationID)) FixUtils.putFixTag( out, FixTags.SENDERLOCATIONID_INT, senderLocationID, 0, Utils.lastIndexTrim(senderLocationID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(targetLocationID)) FixUtils.putFixTag( out, FixTags.TARGETLOCATIONID_INT, targetLocationID, 0, Utils.lastIndexTrim(targetLocationID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfLocationID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFLOCATIONID_INT, onBehalfOfLocationID, 0, Utils.lastIndexTrim(onBehalfOfLocationID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );
		if (FixUtils.isSet(deliverToLocationID)) FixUtils.putFixTag( out, FixTags.DELIVERTOLOCATIONID_INT, deliverToLocationID, 0, Utils.lastIndexTrim(deliverToLocationID, (byte)0) );
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(xmlDataLen)) FixUtils.putFixTag( out, FixTags.XMLDATALEN_INT, xmlDataLen);
		if (FixUtils.isSet(xmlData)) FixUtils.putFixTag( out, FixTags.XMLDATA_INT, xmlData, 0, Utils.lastIndexTrim(xmlData, (byte)0) );
		if (FixUtils.isSet(messageEncoding)) FixUtils.putFixTag( out, FixTags.MESSAGEENCODING_INT, messageEncoding, 0, Utils.lastIndexTrim(messageEncoding, (byte)0) );
		if (FixUtils.isSet(lastMsgSeqNumProcessed)) FixUtils.putFixTag( out, FixTags.LASTMSGSEQNUMPROCESSED_INT, lastMsgSeqNumProcessed);
		if ( FixUtils.isSet(hopGrp.noHops) )hopGrp.encode( out );

		if (FixUtils.isSet(newsID)) FixUtils.putFixTag( out, FixTags.NEWSID_INT, newsID, 0, Utils.lastIndexTrim(newsID, (byte)0) );
		if (FixUtils.isSet(newsCategory)) FixUtils.putFixTag( out, FixTags.NEWSCATEGORY_INT, newsCategory);
		if (FixUtils.isSet(languageCode)) FixUtils.putFixTag( out, FixTags.LANGUAGECODE_INT, languageCode, 0, Utils.lastIndexTrim(languageCode, (byte)0) );
		if (FixUtils.isSet(applicationSequenceControl.applID)) applicationSequenceControl.encode( out );
		if (FixUtils.isSet(newsRefGrp.noNewsRefIDs)) newsRefGrp.encode( out );
		if (FixUtils.isSet(origTime)) FixUtils.putFixTag( out, FixTags.ORIGTIME_INT, origTime);
		if (FixUtils.isSet(urgency)) FixUtils.putFixTag( out, FixTags.URGENCY_INT, urgency );
		FixUtils.putFixTag( out, FixTags.HEADLINE_INT, headline, 0, Utils.lastIndexTrim(headline, (byte)0) );
		if (FixUtils.isSet(encodedHeadlineLen)) FixUtils.putFixTag( out, FixTags.ENCODEDHEADLINELEN_INT, encodedHeadlineLen);
		if (FixUtils.isSet(encodedHeadline)) FixUtils.putFixTag( out, FixTags.ENCODEDHEADLINE_INT, encodedHeadline, 0, Utils.lastIndexTrim(encodedHeadline, (byte)0) );
		if (FixUtils.isSet(routingGrp.noRoutingIDs)) routingGrp.encode( out );
		if (FixUtils.isSet(marketID)) FixUtils.putFixTag( out, FixTags.MARKETID_INT, marketID, 0, Utils.lastIndexTrim(marketID, (byte)0) );
		if (FixUtils.isSet(marketSegmentID)) FixUtils.putFixTag( out, FixTags.MARKETSEGMENTID_INT, marketSegmentID, 0, Utils.lastIndexTrim(marketSegmentID, (byte)0) );
		if (FixUtils.isSet(instrmtGrp.noRelatedSym)) instrmtGrp.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		linesOfTextGrp.encode( out );
		if (FixUtils.isSet(uRLLink)) FixUtils.putFixTag( out, FixTags.URLLINK_INT, uRLLink, 0, Utils.lastIndexTrim(uRLLink, (byte)0) );
		if (FixUtils.isSet(rawDataLength)) FixUtils.putFixTag( out, FixTags.RAWDATALENGTH_INT, rawDataLength);
		if (FixUtils.isSet(rawData)) FixUtils.putFixTag( out, FixTags.RAWDATA_INT, rawData, 0, Utils.lastIndexTrim(rawData, (byte)0) );
		// the checksum at the end

		int checkSumStart = out.position();
		out.position( msgLengthValueStart );
		bodyLength = checkSumStart - msgTypeStart;
		Utils.longToNumeric( out, bodyLength, Utils.digits(FixConstants.MAX_MESSAGE_SIZE) );

		checkSum = FixUtils.computeChecksum( out, msgStart, checkSumStart );
		out.position( checkSumStart );
		FixUtils.putFixTag( out, FixTags.CHECKSUM_INT, checkSum );

		out.flip();

	}
	@Override		
	public void printBuffer(ByteBuffer out) {

		out.put(buf);

		out.flip();

	}

	/**
	 * If you use toString for any other purpose than administrative printout.
	 * You will end up in nifelheim!
	**/
	@Override
	public String toString() {
		char sep = '\n';
		if (Boolean.getBoolean("fix.useOneLiner")) sep = SOH;

		String s = "BeginString(8)=" + new String(BEGINSTRING_VALUE) + sep;
		s += "BodyLength(9)=" + bodyLength + sep;
		s += "MsgType(35)=" + new String(MsgTypes.NEWS) + sep;

		try {
			// print all fields including the header

			if (FixUtils.isSet(applVerID)) s += "ApplVerID(1128)=" + new String(applVerID) + sep;
			if (FixUtils.isSet(cstmApplVerID)) s += "CstmApplVerID(1129)=" + new String(cstmApplVerID) + sep;
			if (FixUtils.isSet(applExtID)) s += "ApplExtID(1156)=" + String.valueOf(applExtID) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(secureDataLen)) s += "SecureDataLen(90)=" + String.valueOf(secureDataLen) + sep;
			if (FixUtils.isSet(secureData)) s += "SecureData(91)=" + new String(secureData) + sep;
			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			if (FixUtils.isSet(senderLocationID)) s += "SenderLocationID(142)=" + new String(senderLocationID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(targetLocationID)) s += "TargetLocationID(143)=" + new String(targetLocationID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(onBehalfOfLocationID)) s += "OnBehalfOfLocationID(144)=" + new String(onBehalfOfLocationID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;
			if (FixUtils.isSet(deliverToLocationID)) s += "DeliverToLocationID(145)=" + new String(deliverToLocationID) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(xmlDataLen)) s += "XmlDataLen(212)=" + String.valueOf(xmlDataLen) + sep;
			if (FixUtils.isSet(xmlData)) s += "XmlData(213)=" + new String(xmlData) + sep;
			if (FixUtils.isSet(messageEncoding)) s += "MessageEncoding(347)=" + new String(messageEncoding) + sep;
			if (FixUtils.isSet(lastMsgSeqNumProcessed)) s += "LastMsgSeqNumProcessed(369)=" + String.valueOf(lastMsgSeqNumProcessed) + sep;
			if (FixUtils.isSet(hopGrp.noHops)) s += hopGrp.toString();

			if (FixUtils.isSet(newsID)) s += "NewsID(1472)=" + new String(newsID) + sep;
			if (FixUtils.isSet(newsCategory)) s += "NewsCategory(1473)=" + String.valueOf(newsCategory) + sep;
			if (FixUtils.isSet(languageCode)) s += "LanguageCode(1474)=" + new String(languageCode) + sep;
			if (FixUtils.isSet(applicationSequenceControl.applID)) s += applicationSequenceControl.toString();
			if (FixUtils.isSet(newsRefGrp.noNewsRefIDs)) s += newsRefGrp.toString();
			if (FixUtils.isSet(origTime)) s += "OrigTime(42)=" + new String(origTime) + sep;
			if (FixUtils.isSet(urgency)) s += "Urgency(61)=" + String.valueOf(urgency) + sep;
			 s += "Headline(148)=" + new String(headline) + sep;
			if (FixUtils.isSet(encodedHeadlineLen)) s += "EncodedHeadlineLen(358)=" + String.valueOf(encodedHeadlineLen) + sep;
			if (FixUtils.isSet(encodedHeadline)) s += "EncodedHeadline(359)=" + new String(encodedHeadline) + sep;
			if (FixUtils.isSet(routingGrp.noRoutingIDs)) s += routingGrp.toString();
			if (FixUtils.isSet(marketID)) s += "MarketID(1301)=" + new String(marketID) + sep;
			if (FixUtils.isSet(marketSegmentID)) s += "MarketSegmentID(1300)=" + new String(marketSegmentID) + sep;
			if (FixUtils.isSet(instrmtGrp.noRelatedSym)) s += instrmtGrp.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			 s += linesOfTextGrp.toString();
			if (FixUtils.isSet(uRLLink)) s += "URLLink(149)=" + new String(uRLLink) + sep;
			if (FixUtils.isSet(rawDataLength)) s += "RawDataLength(95)=" + String.valueOf(rawDataLength) + sep;
			if (FixUtils.isSet(rawData)) s += "RawData(96)=" + new String(rawData) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixNews)) return false;

			FixNews msg = (FixNews) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( newsID, msg.newsID)) return false;

		if (!( newsCategory==msg.newsCategory)) return false;

		if (!Utils.equals( languageCode, msg.languageCode)) return false;

		if (!applicationSequenceControl.equals(msg.applicationSequenceControl)) return false;

		if (!newsRefGrp.equals(msg.newsRefGrp)) return false;

		if (!( urgency==msg.urgency)) return false;

		if (!Utils.equals( headline, msg.headline)) return false;

		if (!( encodedHeadlineLen==msg.encodedHeadlineLen)) return false;

		if (!Utils.equals( encodedHeadline, msg.encodedHeadline)) return false;

		if (!routingGrp.equals(msg.routingGrp)) return false;

		if (!Utils.equals( marketID, msg.marketID)) return false;

		if (!Utils.equals( marketSegmentID, msg.marketSegmentID)) return false;

		if (!instrmtGrp.equals(msg.instrmtGrp)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!linesOfTextGrp.equals(msg.linesOfTextGrp)) return false;

		if (!Utils.equals( uRLLink, msg.uRLLink)) return false;

		if (!( rawDataLength==msg.rawDataLength)) return false;

		if (!Utils.equals( rawData, msg.rawData)) return false;

		return true;
	}
}