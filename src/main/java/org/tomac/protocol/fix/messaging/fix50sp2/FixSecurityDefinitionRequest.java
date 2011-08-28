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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrumentExtension;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixStipulations;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrmtLegGrp;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixSpreadOrBenchmarkCurveData;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixYieldData;

public class FixSecurityDefinitionRequest extends FixMessage
{

	public byte[] securityReqID;
	public long securityRequestType = 0;
	public byte[] marketID;
	public byte[] marketSegmentID;
	public FixInstrument instrument;
	public FixInstrumentExtension instrumentExtension;
	public FixUndInstrmtGrp undInstrmtGrp;
	public byte[] currency;
	public byte[] text;
	public long encodedTextLen = 0;
	public byte[] encodedText;
	public byte[] tradingSessionID;
	public byte[] tradingSessionSubID;
	public FixStipulations stipulations;
	public FixInstrmtLegGrp instrmtLegGrp;
	public FixSpreadOrBenchmarkCurveData spreadOrBenchmarkCurveData;
	public FixYieldData yieldData;
	public long expirationCycle = 0;
	public byte subscriptionRequestType = (byte)' ';

	public FixSecurityDefinitionRequest() {
		super();

		securityReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		marketID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		marketSegmentID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrument = new FixInstrument();
		instrumentExtension = new FixInstrumentExtension();
		undInstrmtGrp = new FixUndInstrmtGrp();
		currency = new byte[FixUtils.CURRENCY_LENGTH];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		encodedText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		tradingSessionID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradingSessionSubID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		stipulations = new FixStipulations();
		instrmtLegGrp = new FixInstrmtLegGrp();
		spreadOrBenchmarkCurveData = new FixSpreadOrBenchmarkCurveData();
		yieldData = new FixYieldData();
		this.clear();

		msgType = MsgTypes.SECURITYDEFINITIONREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( securityReqID, (byte)0 );
		securityRequestType = Long.MAX_VALUE;		
		Utils.fill( marketID, (byte)0 );
		Utils.fill( marketSegmentID, (byte)0 );
		Utils.fill( currency, (byte)0 );
		Utils.fill( text, (byte)0 );
		encodedTextLen = Long.MAX_VALUE;		
		Utils.fill( encodedText, (byte)0 );
		Utils.fill( tradingSessionID, (byte)0 );
		Utils.fill( tradingSessionSubID, (byte)0 );
		expirationCycle = Long.MAX_VALUE;		
		subscriptionRequestType = Byte.MAX_VALUE;		
		instrument.clear();
		instrumentExtension.clear();
		undInstrmtGrp.clear();
		stipulations.clear();
		instrmtLegGrp.clear();
		spreadOrBenchmarkCurveData.clear();
		yieldData.clear();
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
		while ( ( id = FixUtils.getTagId( buf ) ) >= 0 )
		{
			ByteBuffer value;

			value = buf;

			switch( id ) {

			case FixTags.SECURITYREQID_INT:
				securityReqID = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, securityReqID);
				break;

			case FixTags.SECURITYREQUESTTYPE_INT:
				securityRequestType = FixUtils.getTagIntValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value );
				if (!SecurityRequestType.isValid(securityRequestType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + securityRequestType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MARKETID_INT:
				marketID = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, marketID);
				break;

			case FixTags.MARKETSEGMENTID_INT:
				marketSegmentID = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, marketSegmentID);
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.DELIVERYFORM_INT:
				instrumentExtension.getAll(FixTags.DELIVERYFORM_INT, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( MsgTypes.SECURITYDEFINITIONREQUEST ,FixTags.NOUNDERLYINGS_INT ,value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, currency);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, text);
				break;

			case FixTags.ENCODEDTEXTLEN_INT:
				encodedTextLen = FixUtils.getTagIntValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value );
				break;

			case FixTags.ENCODEDTEXT_INT:
				encodedText = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, encodedText);
				break;

			case FixTags.TRADINGSESSIONID_INT:
				tradingSessionID = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, tradingSessionID);
				if (!TradingSessionID.isValid(tradingSessionID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionID + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRADINGSESSIONSUBID_INT:
				tradingSessionSubID = FixUtils.getTagStringValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value, tradingSessionSubID);
				if (!TradingSessionSubID.isValid(tradingSessionSubID) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradingSessionSubID + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.NOSTIPULATIONS_INT:
				stipulations.noStipulations = FixUtils.getTagIntValue( MsgTypes.SECURITYDEFINITIONREQUEST ,FixTags.NOSTIPULATIONS_INT ,value );
				stipulations.getAll(stipulations.noStipulations, value );
				break;

			case FixTags.NOLEGS_INT:
				instrmtLegGrp.noLegs = FixUtils.getTagIntValue( MsgTypes.SECURITYDEFINITIONREQUEST ,FixTags.NOLEGS_INT ,value );
				instrmtLegGrp.getAll(instrmtLegGrp.noLegs, value );
				break;

			case FixTags.SPREAD_INT:
				spreadOrBenchmarkCurveData.getAll(FixTags.SPREAD_INT, value );
				break;

			case FixTags.YIELDTYPE_INT:
				yieldData.getAll(FixTags.YIELDTYPE_INT, value );
				break;

			case FixTags.EXPIRATIONCYCLE_INT:
				expirationCycle = FixUtils.getTagIntValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value );
				if (!ExpirationCycle.isValid(expirationCycle) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + expirationCycle + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SUBSCRIPTIONREQUESTTYPE_INT:
				subscriptionRequestType = FixUtils.getTagCharValue(MsgTypes.SECURITYDEFINITIONREQUEST ,id ,value );
				if (!SubscriptionRequestType.isValid(subscriptionRequestType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + subscriptionRequestType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.SECURITYDEFINITIONREQUEST ,FixTags.CHECKSUM_INT, value );

				id = checkRequiredTags();
				if (id > 0) throw new FixSessionException(SessionRejectReason.REQUIRED_TAG_MISSING, "Required tag missing".getBytes(), id, FixUtils.getMsgType(msgType) );

				return;

			default:
				throw new FixSessionException(SessionRejectReason.UNDEFINED_TAG, "Unknown tag".getBytes(), id, FixUtils.getMsgType(msgType) );

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
		if (! FixUtils.isSet(securityReqID) ) return FixTags.SECURITYREQID_INT;
		if (! FixUtils.isSet(securityRequestType) ) return FixTags.SECURITYREQUESTTYPE_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.SECURITYDEFINITIONREQUEST);

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

		FixUtils.putFixTag( out, FixTags.SECURITYREQID_INT, securityReqID, 0, Utils.lastIndexTrim(securityReqID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SECURITYREQUESTTYPE_INT, securityRequestType);
		if (FixUtils.isSet(marketID)) FixUtils.putFixTag( out, FixTags.MARKETID_INT, marketID, 0, Utils.lastIndexTrim(marketID, (byte)0) );
		if (FixUtils.isSet(marketSegmentID)) FixUtils.putFixTag( out, FixTags.MARKETSEGMENTID_INT, marketSegmentID, 0, Utils.lastIndexTrim(marketSegmentID, (byte)0) );
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(instrumentExtension.deliveryForm)) instrumentExtension.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		if (FixUtils.isSet(currency)) FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		if (FixUtils.isSet(text)) FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		if (FixUtils.isSet(encodedTextLen)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXTLEN_INT, encodedTextLen);
		if (FixUtils.isSet(encodedText)) FixUtils.putFixTag( out, FixTags.ENCODEDTEXT_INT, encodedText, 0, Utils.lastIndexTrim(encodedText, (byte)0) );
		if (FixUtils.isSet(tradingSessionID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONID_INT, tradingSessionID, 0, Utils.lastIndexTrim(tradingSessionID, (byte)0) );
		if (FixUtils.isSet(tradingSessionSubID)) FixUtils.putFixTag( out, FixTags.TRADINGSESSIONSUBID_INT, tradingSessionSubID, 0, Utils.lastIndexTrim(tradingSessionSubID, (byte)0) );
		if (FixUtils.isSet(stipulations.noStipulations)) stipulations.encode( out );
		if (FixUtils.isSet(instrmtLegGrp.noLegs)) instrmtLegGrp.encode( out );
		if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) spreadOrBenchmarkCurveData.encode( out );
		if (FixUtils.isSet(yieldData.yieldType)) yieldData.encode( out );
		if (FixUtils.isSet(expirationCycle)) FixUtils.putFixTag( out, FixTags.EXPIRATIONCYCLE_INT, expirationCycle);
		if (FixUtils.isSet(subscriptionRequestType)) FixUtils.putFixTag( out, FixTags.SUBSCRIPTIONREQUESTTYPE_INT, subscriptionRequestType );
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
		s += "MsgType(35)=" + new String(MsgTypes.SECURITYDEFINITIONREQUEST) + sep;

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

			 s += "SecurityReqID(320)=" + new String(securityReqID) + sep;
			 s += "SecurityRequestType(321)=" + String.valueOf(securityRequestType) + sep;
			if (FixUtils.isSet(marketID)) s += "MarketID(1301)=" + new String(marketID) + sep;
			if (FixUtils.isSet(marketSegmentID)) s += "MarketSegmentID(1300)=" + new String(marketSegmentID) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(instrumentExtension.deliveryForm)) s += instrumentExtension.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			if (FixUtils.isSet(currency)) s += "Currency(15)=" + new String(currency) + sep;
			if (FixUtils.isSet(text)) s += "Text(58)=" + new String(text) + sep;
			if (FixUtils.isSet(encodedTextLen)) s += "EncodedTextLen(354)=" + String.valueOf(encodedTextLen) + sep;
			if (FixUtils.isSet(encodedText)) s += "EncodedText(355)=" + new String(encodedText) + sep;
			if (FixUtils.isSet(tradingSessionID)) s += "TradingSessionID(336)=" + new String(tradingSessionID) + sep;
			if (FixUtils.isSet(tradingSessionSubID)) s += "TradingSessionSubID(625)=" + new String(tradingSessionSubID) + sep;
			if (FixUtils.isSet(stipulations.noStipulations)) s += stipulations.toString();
			if (FixUtils.isSet(instrmtLegGrp.noLegs)) s += instrmtLegGrp.toString();
			if (FixUtils.isSet(spreadOrBenchmarkCurveData.spread)) s += spreadOrBenchmarkCurveData.toString();
			if (FixUtils.isSet(yieldData.yieldType)) s += yieldData.toString();
			if (FixUtils.isSet(expirationCycle)) s += "ExpirationCycle(827)=" + String.valueOf(expirationCycle) + sep;
			if (FixUtils.isSet(subscriptionRequestType)) s += "SubscriptionRequestType(263)=" + String.valueOf(subscriptionRequestType) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixSecurityDefinitionRequest)) return false;

			FixSecurityDefinitionRequest msg = (FixSecurityDefinitionRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( securityReqID, msg.securityReqID)) return false;

		if (!( securityRequestType==msg.securityRequestType)) return false;

		if (!Utils.equals( marketID, msg.marketID)) return false;

		if (!Utils.equals( marketSegmentID, msg.marketSegmentID)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!instrumentExtension.equals(msg.instrumentExtension)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( encodedTextLen==msg.encodedTextLen)) return false;

		if (!Utils.equals( encodedText, msg.encodedText)) return false;

		if (!Utils.equals( tradingSessionID, msg.tradingSessionID)) return false;

		if (!Utils.equals( tradingSessionSubID, msg.tradingSessionSubID)) return false;

		if (!stipulations.equals(msg.stipulations)) return false;

		if (!instrmtLegGrp.equals(msg.instrmtLegGrp)) return false;

		if (!spreadOrBenchmarkCurveData.equals(msg.spreadOrBenchmarkCurveData)) return false;

		if (!yieldData.equals(msg.yieldData)) return false;

		if (!( expirationCycle==msg.expirationCycle)) return false;

		if (!( subscriptionRequestType==msg.subscriptionRequestType)) return false;

		return true;
	}
}
