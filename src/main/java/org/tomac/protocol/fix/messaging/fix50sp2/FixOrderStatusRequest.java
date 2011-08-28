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
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixParties;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixInstrument;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixFinancingDetails;
import org.tomac.protocol.fix.messaging.fix50sp2.component.FixUndInstrmtGrp;

public class FixOrderStatusRequest extends FixMessage
{

	public byte[] orderID;
	public byte[] clOrdID;
	public byte[] secondaryClOrdID;
	public byte[] clOrdLinkID;
	public FixParties parties;
	public byte[] ordStatusReqID;
	public byte[] account;
	public long acctIDSource = 0;
	public FixInstrument instrument;
	public FixFinancingDetails financingDetails;
	public FixUndInstrmtGrp undInstrmtGrp;
	public byte side = (byte)' ';

	public FixOrderStatusRequest() {
		super();

		orderID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		secondaryClOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdLinkID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		ordStatusReqID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		instrument = new FixInstrument();
		financingDetails = new FixFinancingDetails();
		undInstrmtGrp = new FixUndInstrmtGrp();
		this.clear();

		msgType = MsgTypes.ORDERSTATUSREQUEST_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( orderID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( secondaryClOrdID, (byte)0 );
		Utils.fill( clOrdLinkID, (byte)0 );
		Utils.fill( ordStatusReqID, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		side = Byte.MAX_VALUE;		
		parties.clear();
		instrument.clear();
		financingDetails.clear();
		undInstrmtGrp.clear();
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

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, orderID);
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, clOrdID);
				break;

			case FixTags.SECONDARYCLORDID_INT:
				secondaryClOrdID = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, secondaryClOrdID);
				break;

			case FixTags.CLORDLINKID_INT:
				clOrdLinkID = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, clOrdLinkID);
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( MsgTypes.ORDERSTATUSREQUEST ,FixTags.NOPARTYIDS_INT ,value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.ORDSTATUSREQID_INT:
				ordStatusReqID = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, ordStatusReqID);
				break;

			case FixTags.ACCOUNT_INT:
				account = FixUtils.getTagStringValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value, account);
				break;

			case FixTags.ACCTIDSOURCE_INT:
				acctIDSource = FixUtils.getTagIntValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value );
				if (!AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + acctIDSource + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SYMBOL_INT:
				instrument.getAll(FixTags.SYMBOL_INT, value );
				break;

			case FixTags.AGREEMENTDESC_INT:
				financingDetails.getAll(FixTags.AGREEMENTDESC_INT, value );
				break;

			case FixTags.NOUNDERLYINGS_INT:
				undInstrmtGrp.noUnderlyings = FixUtils.getTagIntValue( MsgTypes.ORDERSTATUSREQUEST ,FixTags.NOUNDERLYINGS_INT ,value );
				undInstrmtGrp.getAll(undInstrmtGrp.noUnderlyings, value );
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue(MsgTypes.ORDERSTATUSREQUEST ,id ,value );
				if (!Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.ORDERSTATUSREQUEST ,FixTags.CHECKSUM_INT, value );

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
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! instrument.isSet() ) return FixTags.SYMBOL_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ORDERSTATUSREQUEST);

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

		if (FixUtils.isSet(orderID)) FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(secondaryClOrdID)) FixUtils.putFixTag( out, FixTags.SECONDARYCLORDID_INT, secondaryClOrdID, 0, Utils.lastIndexTrim(secondaryClOrdID, (byte)0) );
		if (FixUtils.isSet(clOrdLinkID)) FixUtils.putFixTag( out, FixTags.CLORDLINKID_INT, clOrdLinkID, 0, Utils.lastIndexTrim(clOrdLinkID, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(ordStatusReqID)) FixUtils.putFixTag( out, FixTags.ORDSTATUSREQID_INT, ordStatusReqID, 0, Utils.lastIndexTrim(ordStatusReqID, (byte)0) );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		if (FixUtils.isSet(instrument.symbol)) instrument.encode( out );
		if (FixUtils.isSet(financingDetails.agreementDesc)) financingDetails.encode( out );
		if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) undInstrmtGrp.encode( out );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
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
		s += "MsgType(35)=" + new String(MsgTypes.ORDERSTATUSREQUEST) + sep;

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

			if (FixUtils.isSet(orderID)) s += "OrderID(37)=" + new String(orderID) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(secondaryClOrdID)) s += "SecondaryClOrdID(526)=" + new String(secondaryClOrdID) + sep;
			if (FixUtils.isSet(clOrdLinkID)) s += "ClOrdLinkID(583)=" + new String(clOrdLinkID) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(ordStatusReqID)) s += "OrdStatusReqID(790)=" + new String(ordStatusReqID) + sep;
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			if (FixUtils.isSet(instrument.symbol)) s += instrument.toString();
			if (FixUtils.isSet(financingDetails.agreementDesc)) s += financingDetails.toString();
			if (FixUtils.isSet(undInstrmtGrp.noUnderlyings)) s += undInstrmtGrp.toString();
			 s += "Side(54)=" + String.valueOf(side) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixOrderStatusRequest)) return false;

			FixOrderStatusRequest msg = (FixOrderStatusRequest) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!Utils.equals( secondaryClOrdID, msg.secondaryClOrdID)) return false;

		if (!Utils.equals( clOrdLinkID, msg.clOrdLinkID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!Utils.equals( ordStatusReqID, msg.ordStatusReqID)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!instrument.equals(msg.instrument)) return false;

		if (!financingDetails.equals(msg.financingDetails)) return false;

		if (!undInstrmtGrp.equals(msg.undInstrmtGrp)) return false;

		if (!( side==msg.side)) return false;

		return true;
	}
}
