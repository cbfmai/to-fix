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

public class FixRegistrationInstructionsResponse extends FixMessage
{

	public byte[] registID;
	public byte registTransType = (byte)' ';
	public byte[] registRefID;
	public byte[] clOrdID;
	public FixParties parties;
	public byte[] account;
	public long acctIDSource = 0;
	public byte registStatus = (byte)' ';
	public long registRejReasonCode = 0;
	public byte[] registRejReasonText;

	public FixRegistrationInstructionsResponse() {
		super();

		registID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		registRefID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clOrdID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		parties = new FixParties();
		account = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		registRejReasonText = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		this.clear();

		msgType = MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		Utils.fill( registID, (byte)0 );
		registTransType = Byte.MAX_VALUE;		
		Utils.fill( registRefID, (byte)0 );
		Utils.fill( clOrdID, (byte)0 );
		Utils.fill( account, (byte)0 );
		acctIDSource = Long.MAX_VALUE;		
		registStatus = Byte.MAX_VALUE;		
		registRejReasonCode = Long.MAX_VALUE;		
		Utils.fill( registRejReasonText, (byte)0 );
		parties.clear();
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

			case FixTags.REGISTID_INT:
				registID = FixUtils.getTagStringValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value, registID);
				break;

			case FixTags.REGISTTRANSTYPE_INT:
				registTransType = FixUtils.getTagCharValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value );
				if (!RegistTransType.isValid(registTransType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + registTransType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.REGISTREFID_INT:
				registRefID = FixUtils.getTagStringValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value, registRefID);
				break;

			case FixTags.CLORDID_INT:
				clOrdID = FixUtils.getTagStringValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value, clOrdID);
				break;

			case FixTags.NOPARTYIDS_INT:
				parties.noPartyIDs = FixUtils.getTagIntValue( MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,FixTags.NOPARTYIDS_INT ,value );
				parties.getAll(parties.noPartyIDs, value );
				break;

			case FixTags.ACCOUNT_INT:
				account = FixUtils.getTagStringValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value, account);
				break;

			case FixTags.ACCTIDSOURCE_INT:
				acctIDSource = FixUtils.getTagIntValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value );
				if (!AcctIDSource.isValid(acctIDSource) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + acctIDSource + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.REGISTSTATUS_INT:
				registStatus = FixUtils.getTagCharValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value );
				if (!RegistStatus.isValid(registStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + registStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.REGISTREJREASONCODE_INT:
				registRejReasonCode = FixUtils.getTagIntValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value );
				if (!RegistRejReasonCode.isValid(registRejReasonCode) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + registRejReasonCode + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.REGISTREJREASONTEXT_INT:
				registRejReasonText = FixUtils.getTagStringValue(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,id ,value, registRejReasonText);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE ,FixTags.CHECKSUM_INT, value );

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
		if (! FixUtils.isSet(registID) ) return FixTags.REGISTID_INT;
		if (! FixUtils.isSet(registTransType) ) return FixTags.REGISTTRANSTYPE_INT;
		if (! FixUtils.isSet(registRefID) ) return FixTags.REGISTREFID_INT;
		if (! FixUtils.isSet(registStatus) ) return FixTags.REGISTSTATUS_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE);

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

		FixUtils.putFixTag( out, FixTags.REGISTID_INT, registID, 0, Utils.lastIndexTrim(registID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.REGISTTRANSTYPE_INT, registTransType );
		FixUtils.putFixTag( out, FixTags.REGISTREFID_INT, registRefID, 0, Utils.lastIndexTrim(registRefID, (byte)0) );
		if (FixUtils.isSet(clOrdID)) FixUtils.putFixTag( out, FixTags.CLORDID_INT, clOrdID, 0, Utils.lastIndexTrim(clOrdID, (byte)0) );
		if (FixUtils.isSet(parties.noPartyIDs)) parties.encode( out );
		if (FixUtils.isSet(account)) FixUtils.putFixTag( out, FixTags.ACCOUNT_INT, account, 0, Utils.lastIndexTrim(account, (byte)0) );
		if (FixUtils.isSet(acctIDSource)) FixUtils.putFixTag( out, FixTags.ACCTIDSOURCE_INT, acctIDSource);
		FixUtils.putFixTag( out, FixTags.REGISTSTATUS_INT, registStatus );
		if (FixUtils.isSet(registRejReasonCode)) FixUtils.putFixTag( out, FixTags.REGISTREJREASONCODE_INT, registRejReasonCode);
		if (FixUtils.isSet(registRejReasonText)) FixUtils.putFixTag( out, FixTags.REGISTREJREASONTEXT_INT, registRejReasonText, 0, Utils.lastIndexTrim(registRejReasonText, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.REGISTRATIONINSTRUCTIONSRESPONSE) + sep;

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

			 s += "RegistID(513)=" + new String(registID) + sep;
			 s += "RegistTransType(514)=" + String.valueOf(registTransType) + sep;
			 s += "RegistRefID(508)=" + new String(registRefID) + sep;
			if (FixUtils.isSet(clOrdID)) s += "ClOrdID(11)=" + new String(clOrdID) + sep;
			if (FixUtils.isSet(parties.noPartyIDs)) s += parties.toString();
			if (FixUtils.isSet(account)) s += "Account(1)=" + new String(account) + sep;
			if (FixUtils.isSet(acctIDSource)) s += "AcctIDSource(660)=" + String.valueOf(acctIDSource) + sep;
			 s += "RegistStatus(506)=" + String.valueOf(registStatus) + sep;
			if (FixUtils.isSet(registRejReasonCode)) s += "RegistRejReasonCode(507)=" + String.valueOf(registRejReasonCode) + sep;
			if (FixUtils.isSet(registRejReasonText)) s += "RegistRejReasonText(496)=" + new String(registRejReasonText) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixRegistrationInstructionsResponse)) return false;

			FixRegistrationInstructionsResponse msg = (FixRegistrationInstructionsResponse) o;

		if ( ! super.equals(msg) ) return false;

		if (!Utils.equals( registID, msg.registID)) return false;

		if (!( registTransType==msg.registTransType)) return false;

		if (!Utils.equals( registRefID, msg.registRefID)) return false;

		if (!Utils.equals( clOrdID, msg.clOrdID)) return false;

		if (!parties.equals(msg.parties)) return false;

		if (!Utils.equals( account, msg.account)) return false;

		if (!( acctIDSource==msg.acctIDSource)) return false;

		if (!( registStatus==msg.registStatus)) return false;

		if (!( registRejReasonCode==msg.registRejReasonCode)) return false;

		if (!Utils.equals( registRejReasonText, msg.registRejReasonText)) return false;

		return true;
	}
}
