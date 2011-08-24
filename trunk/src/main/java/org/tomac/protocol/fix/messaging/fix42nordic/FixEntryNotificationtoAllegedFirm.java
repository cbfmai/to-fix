package org.tomac.protocol.fix.messaging.fix42nordic;

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



public class FixEntryNotificationtoAllegedFirm extends FixMessage
{

	public long avgPx = 0;
	public long cumQty = 0;
	public byte[] currency;
	public byte[] execID;
	public byte execTransType = (byte)' ';
	public byte[] orderID;
	public byte ordStatus = (byte)' ';
	public byte[] securityID;
	public byte side = (byte)' ';
	public byte[] symbol;
	public byte[] text;
	public byte[] transactTime;
	public byte[] futSettDate;
	public byte processCode = (byte)' ';
	public byte[] securityDesc;
	public byte[] clientID;
	public byte execType = (byte)' ';
	public long leavesQty = 0;
	public long noContraBrokers = 0;
	public byte[] contraBroker;
	public long priceType = 0;
	public byte[] transBkdTime;
	public byte[] tradeReportID;
	public byte[] clearingInstruction;
	public byte[] reversalIndicator;
	public byte[] tradeType;
	public byte[] publishTrdIndicator;
	public byte[] tradeReportType;
	public byte[] trdMatchID;
	public byte[] trdRptStatus;
	public byte[] memo;
	public byte[] subMktID;
	public byte contraOrderRestrictions = (byte)' ';
	public byte[] mICCode;
	public long clearingPrice = 0;
	public byte overrideFlag = (byte)' ';
	public byte delayedDisseminationInst = (byte)' ';
	public byte contraTradePA = (byte)' ';
	public byte[] contraClearingAcct;

	public FixEntryNotificationtoAllegedFirm() {
		super();

		currency = new byte[FixUtils.CURRENCY_LENGTH];
		execID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		orderID = new byte[32];
		securityID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		symbol = new byte[8];
		text = new byte[FixUtils.FIX_MAX_STRING_TEXT_LENGTH];
		transactTime = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		futSettDate = new byte[FixUtils.UTCTIMESTAMP_LENGTH];
		securityDesc = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		clientID = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		contraBroker = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		transBkdTime = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeReportID = new byte[20];
		clearingInstruction = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		reversalIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		publishTrdIndicator = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		tradeReportType = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		trdMatchID = new byte[10];
		trdRptStatus = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		memo = new byte[10];
		subMktID = new byte[3];
		mICCode = new byte[4];
		contraClearingAcct = new byte[FixUtils.FIX_MAX_STRING_LENGTH];
		this.clear();

		msgType = MsgTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM_INT;

	}

	@Override
	public void clear()
	{

		// clear out all the fields that aren't msgType

		avgPx = Long.MAX_VALUE;		
		cumQty = Long.MAX_VALUE;		
		Utils.fill( currency, (byte)0 );
		Utils.fill( execID, (byte)0 );
		execTransType = Byte.MAX_VALUE;		
		Utils.fill( orderID, (byte)0 );
		ordStatus = Byte.MAX_VALUE;		
		Utils.fill( securityID, (byte)0 );
		side = Byte.MAX_VALUE;		
		Utils.fill( symbol, (byte)0 );
		Utils.fill( text, (byte)0 );
		Utils.fill( transactTime, (byte)0 );
		Utils.fill( futSettDate, (byte)0 );
		processCode = Byte.MAX_VALUE;		
		Utils.fill( securityDesc, (byte)0 );
		Utils.fill( clientID, (byte)0 );
		execType = Byte.MAX_VALUE;		
		leavesQty = Long.MAX_VALUE;		
		noContraBrokers = Long.MAX_VALUE;		
		Utils.fill( contraBroker, (byte)0 );
		priceType = Long.MAX_VALUE;		
		Utils.fill( transBkdTime, (byte)0 );
		Utils.fill( tradeReportID, (byte)0 );
		Utils.fill( clearingInstruction, (byte)0 );
		Utils.fill( reversalIndicator, (byte)0 );
		Utils.fill( tradeType, (byte)0 );
		Utils.fill( publishTrdIndicator, (byte)0 );
		Utils.fill( tradeReportType, (byte)0 );
		Utils.fill( trdMatchID, (byte)0 );
		Utils.fill( trdRptStatus, (byte)0 );
		Utils.fill( memo, (byte)0 );
		Utils.fill( subMktID, (byte)0 );
		contraOrderRestrictions = Byte.MAX_VALUE;		
		Utils.fill( mICCode, (byte)0 );
		clearingPrice = Long.MAX_VALUE;		
		overrideFlag = Byte.MAX_VALUE;		
		delayedDisseminationInst = Byte.MAX_VALUE;		
		contraTradePA = Byte.MAX_VALUE;		
		Utils.fill( contraClearingAcct, (byte)0 );
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

			case FixTags.AVGPX_INT:
				avgPx = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.CUMQTY_INT:
				cumQty = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.CURRENCY_INT:
				currency = FixUtils.getTagStringValue(value, currency);
				break;

			case FixTags.EXECID_INT:
				execID = FixUtils.getTagStringValue(value, execID);
				break;

			case FixTags.EXECTRANSTYPE_INT:
				execTransType = FixUtils.getTagCharValue( value );
				if (!ExecTransType.isValid(execTransType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + execTransType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.ORDERID_INT:
				orderID = FixUtils.getTagStringValue(value, orderID);
				break;

			case FixTags.ORDSTATUS_INT:
				ordStatus = FixUtils.getTagCharValue( value );
				if (!OrdStatus.isValid(ordStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + ordStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SECURITYID_INT:
				securityID = FixUtils.getTagStringValue(value, securityID);
				break;

			case FixTags.SIDE_INT:
				side = FixUtils.getTagCharValue( value );
				if (!Side.isValid(side) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + side + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SYMBOL_INT:
				symbol = FixUtils.getTagStringValue(value, symbol);
				break;

			case FixTags.TEXT_INT:
				text = FixUtils.getTagStringValue(value, text);
				break;

			case FixTags.TRANSACTTIME_INT:
				transactTime = FixUtils.getTagStringValue(value, transactTime);
				break;

			case FixTags.FUTSETTDATE_INT:
				futSettDate = FixUtils.getTagStringValue(value, futSettDate);
				break;

			case FixTags.PROCESSCODE_INT:
				processCode = FixUtils.getTagCharValue( value );
				if (!ProcessCode.isValid(processCode) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + processCode + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.SECURITYDESC_INT:
				securityDesc = FixUtils.getTagStringValue(value, securityDesc);
				if (!SecurityDesc.isValid(securityDesc) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + securityDesc + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CLIENTID_INT:
				clientID = FixUtils.getTagStringValue(value, clientID);
				break;

			case FixTags.EXECTYPE_INT:
				execType = FixUtils.getTagCharValue( value );
				if (!ExecType.isValid(execType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + execType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.LEAVESQTY_INT:
				leavesQty = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.NOCONTRABROKERS_INT:
				noContraBrokers = FixUtils.getTagIntValue( value );
				break;

			case FixTags.CONTRABROKER_INT:
				contraBroker = FixUtils.getTagStringValue(value, contraBroker);
				break;

			case FixTags.PRICETYPE_INT:
				priceType = FixUtils.getTagIntValue( value );
				if (!PriceType.isValid(priceType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + priceType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRANSBKDTIME_INT:
				transBkdTime = FixUtils.getTagStringValue(value, transBkdTime);
				break;

			case FixTags.TRADEREPORTID_INT:
				tradeReportID = FixUtils.getTagStringValue(value, tradeReportID);
				break;

			case FixTags.CLEARINGINSTRUCTION_INT:
				clearingInstruction = FixUtils.getTagStringValue(value, clearingInstruction);
				if (!ClearingInstruction.isValid(clearingInstruction) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + clearingInstruction + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.REVERSALINDICATOR_INT:
				reversalIndicator = FixUtils.getTagStringValue(value, reversalIndicator);
				if (!ReversalIndicator.isValid(reversalIndicator) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + reversalIndicator + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRADETYPE_INT:
				tradeType = FixUtils.getTagStringValue(value, tradeType);
				if (!TradeType.isValid(tradeType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradeType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.PUBLISHTRDINDICATOR_INT:
				publishTrdIndicator = FixUtils.getTagStringValue(value, publishTrdIndicator);
				if (!PublishTrdIndicator.isValid(publishTrdIndicator) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + publishTrdIndicator + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRADEREPORTTYPE_INT:
				tradeReportType = FixUtils.getTagStringValue(value, tradeReportType);
				if (!TradeReportType.isValid(tradeReportType) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + tradeReportType + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.TRDMATCHID_INT:
				trdMatchID = FixUtils.getTagStringValue(value, trdMatchID);
				break;

			case FixTags.TRDRPTSTATUS_INT:
				trdRptStatus = FixUtils.getTagStringValue(value, trdRptStatus);
				if (!TrdRptStatus.isValid(trdRptStatus) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + trdRptStatus + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MEMO_INT:
				memo = FixUtils.getTagStringValue(value, memo);
				break;

			case FixTags.SUBMKTID_INT:
				subMktID = FixUtils.getTagStringValue(value, subMktID);
				break;

			case FixTags.CONTRAORDERRESTRICTIONS_INT:
				contraOrderRestrictions = FixUtils.getTagCharValue( value );
				if (!ContraOrderRestrictions.isValid(contraOrderRestrictions) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + contraOrderRestrictions + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.MICCODE_INT:
				mICCode = FixUtils.getTagStringValue(value, mICCode);
				break;

			case FixTags.CLEARINGPRICE_INT:
				clearingPrice = FixUtils.getTagFloatValue(value);
				break;

			case FixTags.OVERRIDEFLAG_INT:
				overrideFlag = FixUtils.getTagCharValue( value );
				if (!OverrideFlag.isValid(overrideFlag) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + overrideFlag + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.DELAYEDDISSEMINATIONINST_INT:
				delayedDisseminationInst = FixUtils.getTagCharValue( value );
				if (!DelayedDisseminationInst.isValid(delayedDisseminationInst) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + delayedDisseminationInst + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CONTRATRADEPA_INT:
				contraTradePA = FixUtils.getTagCharValue( value );
				if (!ContraTradePA.isValid(contraTradePA) ) throw new FixSessionException(SessionRejectReason.VALUE_IS_INCORRECT_OUT_OF_RANGE_FOR_THIS_TAG, ("Invalid enumerated value(" + contraTradePA + ") for tag").getBytes(), id, FixUtils.getMsgType(msgType) );
				break;

			case FixTags.CONTRACLEARINGACCT_INT:
				contraClearingAcct = FixUtils.getTagStringValue(value, contraClearingAcct);
				break;

			// for a message always get the checksum
			case FixTags.CHECKSUM_INT:
				checkSum = FixUtils.getTagIntValue( value );

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

		if (! FixUtils.isSet(msgSeqNum) ) return FixTags.MSGSEQNUM_INT;
		if (! FixUtils.isSet(senderCompID) ) return FixTags.SENDERCOMPID_INT;
		if (! FixUtils.isSet(sendingTime) ) return FixTags.SENDINGTIME_INT;
		if (! FixUtils.isSet(targetCompID) ) return FixTags.TARGETCOMPID_INT;
		if (! FixUtils.isSet(avgPx) ) return FixTags.AVGPX_INT;
		if (! FixUtils.isSet(cumQty) ) return FixTags.CUMQTY_INT;
		if (! FixUtils.isSet(currency) ) return FixTags.CURRENCY_INT;
		if (! FixUtils.isSet(execID) ) return FixTags.EXECID_INT;
		if (! FixUtils.isSet(execTransType) ) return FixTags.EXECTRANSTYPE_INT;
		if (! FixUtils.isSet(orderID) ) return FixTags.ORDERID_INT;
		if (! FixUtils.isSet(ordStatus) ) return FixTags.ORDSTATUS_INT;
		if (! FixUtils.isSet(securityID) ) return FixTags.SECURITYID_INT;
		if (! FixUtils.isSet(side) ) return FixTags.SIDE_INT;
		if (! FixUtils.isSet(symbol) ) return FixTags.SYMBOL_INT;
		if (! FixUtils.isSet(text) ) return FixTags.TEXT_INT;
		if (! FixUtils.isSet(transactTime) ) return FixTags.TRANSACTTIME_INT;
		if (! FixUtils.isSet(securityDesc) ) return FixTags.SECURITYDESC_INT;
		if (! FixUtils.isSet(clientID) ) return FixTags.CLIENTID_INT;
		if (! FixUtils.isSet(execType) ) return FixTags.EXECTYPE_INT;
		if (! FixUtils.isSet(leavesQty) ) return FixTags.LEAVESQTY_INT;
		if (! FixUtils.isSet(contraBroker) ) return FixTags.CONTRABROKER_INT;
		if (! FixUtils.isSet(transBkdTime) ) return FixTags.TRANSBKDTIME_INT;
		if (! FixUtils.isSet(tradeReportID) ) return FixTags.TRADEREPORTID_INT;
		if (! FixUtils.isSet(tradeType) ) return FixTags.TRADETYPE_INT;
		if (! FixUtils.isSet(tradeReportType) ) return FixTags.TRADEREPORTTYPE_INT;
		if (! FixUtils.isSet(trdMatchID) ) return FixTags.TRDMATCHID_INT;
		if (! FixUtils.isSet(subMktID) ) return FixTags.SUBMKTID_INT;
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

		FixUtils.putFixTag( out, FixTags.MSGTYPE_INT, MsgTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM);

		// encode all fields including the header

		FixUtils.putFixTag( out, FixTags.MSGSEQNUM_INT, msgSeqNum);
		if (FixUtils.isSet(possDupFlag)) FixUtils.putFixTag( out, FixTags.POSSDUPFLAG_INT, possDupFlag?(byte)'Y':(byte)'N' );
		FixUtils.putFixTag( out, FixTags.SENDERCOMPID_INT, senderCompID, 0, Utils.lastIndexTrim(senderCompID, (byte)0) );
		if (FixUtils.isSet(senderSubID)) FixUtils.putFixTag( out, FixTags.SENDERSUBID_INT, senderSubID, 0, Utils.lastIndexTrim(senderSubID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SENDINGTIME_INT, sendingTime);
		FixUtils.putFixTag( out, FixTags.TARGETCOMPID_INT, targetCompID, 0, Utils.lastIndexTrim(targetCompID, (byte)0) );
		if (FixUtils.isSet(targetSubID)) FixUtils.putFixTag( out, FixTags.TARGETSUBID_INT, targetSubID, 0, Utils.lastIndexTrim(targetSubID, (byte)0) );
		if (FixUtils.isSet(possResend)) FixUtils.putFixTag( out, FixTags.POSSRESEND_INT, possResend?(byte)'Y':(byte)'N' );
		if (FixUtils.isSet(onBehalfOfCompID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFCOMPID_INT, onBehalfOfCompID, 0, Utils.lastIndexTrim(onBehalfOfCompID, (byte)0) );
		if (FixUtils.isSet(onBehalfOfSubID)) FixUtils.putFixTag( out, FixTags.ONBEHALFOFSUBID_INT, onBehalfOfSubID, 0, Utils.lastIndexTrim(onBehalfOfSubID, (byte)0) );
		if (FixUtils.isSet(origSendingTime)) FixUtils.putFixTag( out, FixTags.ORIGSENDINGTIME_INT, origSendingTime);
		if (FixUtils.isSet(deliverToCompID)) FixUtils.putFixTag( out, FixTags.DELIVERTOCOMPID_INT, deliverToCompID, 0, Utils.lastIndexTrim(deliverToCompID, (byte)0) );
		if (FixUtils.isSet(deliverToSubID)) FixUtils.putFixTag( out, FixTags.DELIVERTOSUBID_INT, deliverToSubID, 0, Utils.lastIndexTrim(deliverToSubID, (byte)0) );

		FixUtils.putFixFloatTag( out, FixTags.AVGPX_INT, avgPx);
		FixUtils.putFixFloatTag( out, FixTags.CUMQTY_INT, cumQty);
		FixUtils.putFixTag( out, FixTags.CURRENCY_INT, currency, 0, Utils.lastIndexTrim(currency, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECID_INT, execID, 0, Utils.lastIndexTrim(execID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTRANSTYPE_INT, execTransType );
		FixUtils.putFixTag( out, FixTags.ORDERID_INT, orderID, 0, Utils.lastIndexTrim(orderID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.ORDSTATUS_INT, ordStatus );
		FixUtils.putFixTag( out, FixTags.SECURITYID_INT, securityID, 0, Utils.lastIndexTrim(securityID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SIDE_INT, side );
		FixUtils.putFixTag( out, FixTags.SYMBOL_INT, symbol, 0, Utils.lastIndexTrim(symbol, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TEXT_INT, text, 0, Utils.lastIndexTrim(text, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRANSACTTIME_INT, transactTime);
		if (FixUtils.isSet(futSettDate)) FixUtils.putFixTag( out, FixTags.FUTSETTDATE_INT, futSettDate);
		if (FixUtils.isSet(processCode)) FixUtils.putFixTag( out, FixTags.PROCESSCODE_INT, processCode );
		FixUtils.putFixTag( out, FixTags.SECURITYDESC_INT, securityDesc, 0, Utils.lastIndexTrim(securityDesc, (byte)0) );
		FixUtils.putFixTag( out, FixTags.CLIENTID_INT, clientID, 0, Utils.lastIndexTrim(clientID, (byte)0) );
		FixUtils.putFixTag( out, FixTags.EXECTYPE_INT, execType );
		FixUtils.putFixFloatTag( out, FixTags.LEAVESQTY_INT, leavesQty);
		if (FixUtils.isSet(noContraBrokers)) FixUtils.putFixTag( out, FixTags.NOCONTRABROKERS_INT, noContraBrokers);
		FixUtils.putFixTag( out, FixTags.CONTRABROKER_INT, contraBroker, 0, Utils.lastIndexTrim(contraBroker, (byte)0) );
		if (FixUtils.isSet(priceType)) FixUtils.putFixTag( out, FixTags.PRICETYPE_INT, priceType);
		FixUtils.putFixTag( out, FixTags.TRANSBKDTIME_INT, transBkdTime, 0, Utils.lastIndexTrim(transBkdTime, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEREPORTID_INT, tradeReportID, 0, Utils.lastIndexTrim(tradeReportID, (byte)0) );
		if (FixUtils.isSet(clearingInstruction)) FixUtils.putFixTag( out, FixTags.CLEARINGINSTRUCTION_INT, clearingInstruction, 0, Utils.lastIndexTrim(clearingInstruction, (byte)0) );
		if (FixUtils.isSet(reversalIndicator)) FixUtils.putFixTag( out, FixTags.REVERSALINDICATOR_INT, reversalIndicator, 0, Utils.lastIndexTrim(reversalIndicator, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADETYPE_INT, tradeType, 0, Utils.lastIndexTrim(tradeType, (byte)0) );
		if (FixUtils.isSet(publishTrdIndicator)) FixUtils.putFixTag( out, FixTags.PUBLISHTRDINDICATOR_INT, publishTrdIndicator, 0, Utils.lastIndexTrim(publishTrdIndicator, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRADEREPORTTYPE_INT, tradeReportType, 0, Utils.lastIndexTrim(tradeReportType, (byte)0) );
		FixUtils.putFixTag( out, FixTags.TRDMATCHID_INT, trdMatchID, 0, Utils.lastIndexTrim(trdMatchID, (byte)0) );
		if (FixUtils.isSet(trdRptStatus)) FixUtils.putFixTag( out, FixTags.TRDRPTSTATUS_INT, trdRptStatus, 0, Utils.lastIndexTrim(trdRptStatus, (byte)0) );
		if (FixUtils.isSet(memo)) FixUtils.putFixTag( out, FixTags.MEMO_INT, memo, 0, Utils.lastIndexTrim(memo, (byte)0) );
		FixUtils.putFixTag( out, FixTags.SUBMKTID_INT, subMktID, 0, Utils.lastIndexTrim(subMktID, (byte)0) );
		if (FixUtils.isSet(contraOrderRestrictions)) FixUtils.putFixTag( out, FixTags.CONTRAORDERRESTRICTIONS_INT, contraOrderRestrictions );
		if (FixUtils.isSet(mICCode)) FixUtils.putFixTag( out, FixTags.MICCODE_INT, mICCode, 0, Utils.lastIndexTrim(mICCode, (byte)0) );
		if (FixUtils.isSet(clearingPrice)) FixUtils.putFixFloatTag( out, FixTags.CLEARINGPRICE_INT, clearingPrice);
		if (FixUtils.isSet(overrideFlag)) FixUtils.putFixTag( out, FixTags.OVERRIDEFLAG_INT, overrideFlag );
		if (FixUtils.isSet(delayedDisseminationInst)) FixUtils.putFixTag( out, FixTags.DELAYEDDISSEMINATIONINST_INT, delayedDisseminationInst );
		if (FixUtils.isSet(contraTradePA)) FixUtils.putFixTag( out, FixTags.CONTRATRADEPA_INT, contraTradePA );
		if (FixUtils.isSet(contraClearingAcct)) FixUtils.putFixTag( out, FixTags.CONTRACLEARINGACCT_INT, contraClearingAcct, 0, Utils.lastIndexTrim(contraClearingAcct, (byte)0) );
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
		s += "MsgType(35)=" + new String(MsgTypes.ENTRYNOTIFICATIONTOALLEGEDFIRM) + sep;

		try {
			// print all fields including the header

			 s += "MsgSeqNum(34)=" + String.valueOf(msgSeqNum) + sep;
			if (FixUtils.isSet(possDupFlag)) s += "PossDupFlag(43)=" + String.valueOf(possDupFlag) + sep;
			 s += "SenderCompID(49)=" + new String(senderCompID) + sep;
			if (FixUtils.isSet(senderSubID)) s += "SenderSubID(50)=" + new String(senderSubID) + sep;
			 s += "SendingTime(52)=" + new String(sendingTime) + sep;
			 s += "TargetCompID(56)=" + new String(targetCompID) + sep;
			if (FixUtils.isSet(targetSubID)) s += "TargetSubID(57)=" + new String(targetSubID) + sep;
			if (FixUtils.isSet(possResend)) s += "PossResend(97)=" + String.valueOf(possResend) + sep;
			if (FixUtils.isSet(onBehalfOfCompID)) s += "OnBehalfOfCompID(115)=" + new String(onBehalfOfCompID) + sep;
			if (FixUtils.isSet(onBehalfOfSubID)) s += "OnBehalfOfSubID(116)=" + new String(onBehalfOfSubID) + sep;
			if (FixUtils.isSet(origSendingTime)) s += "OrigSendingTime(122)=" + new String(origSendingTime) + sep;
			if (FixUtils.isSet(deliverToCompID)) s += "DeliverToCompID(128)=" + new String(deliverToCompID) + sep;
			if (FixUtils.isSet(deliverToSubID)) s += "DeliverToSubID(129)=" + new String(deliverToSubID) + sep;

			 s += "AvgPx(6)=" + String.valueOf(avgPx) + sep;
			 s += "CumQty(14)=" + String.valueOf(cumQty) + sep;
			 s += "Currency(15)=" + new String(currency) + sep;
			 s += "ExecID(17)=" + new String(execID) + sep;
			 s += "ExecTransType(20)=" + String.valueOf(execTransType) + sep;
			 s += "OrderID(37)=" + new String(orderID) + sep;
			 s += "OrdStatus(39)=" + String.valueOf(ordStatus) + sep;
			 s += "SecurityID(48)=" + new String(securityID) + sep;
			 s += "Side(54)=" + String.valueOf(side) + sep;
			 s += "Symbol(55)=" + new String(symbol) + sep;
			 s += "Text(58)=" + new String(text) + sep;
			 s += "TransactTime(60)=" + new String(transactTime) + sep;
			if (FixUtils.isSet(futSettDate)) s += "FutSettDate(64)=" + new String(futSettDate) + sep;
			if (FixUtils.isSet(processCode)) s += "ProcessCode(81)=" + String.valueOf(processCode) + sep;
			 s += "SecurityDesc(107)=" + new String(securityDesc) + sep;
			 s += "ClientID(109)=" + new String(clientID) + sep;
			 s += "ExecType(150)=" + String.valueOf(execType) + sep;
			 s += "LeavesQty(151)=" + String.valueOf(leavesQty) + sep;
			if (FixUtils.isSet(noContraBrokers)) s += "NoContraBrokers(382)=" + String.valueOf(noContraBrokers) + sep;
			 s += "ContraBroker(375)=" + new String(contraBroker) + sep;
			if (FixUtils.isSet(priceType)) s += "PriceType(423)=" + String.valueOf(priceType) + sep;
			 s += "TransBkdTime(483)=" + new String(transBkdTime) + sep;
			 s += "TradeReportID(571)=" + new String(tradeReportID) + sep;
			if (FixUtils.isSet(clearingInstruction)) s += "ClearingInstruction(577)=" + new String(clearingInstruction) + sep;
			if (FixUtils.isSet(reversalIndicator)) s += "ReversalIndicator(700)=" + new String(reversalIndicator) + sep;
			 s += "TradeType(828)=" + new String(tradeType) + sep;
			if (FixUtils.isSet(publishTrdIndicator)) s += "PublishTrdIndicator(852)=" + new String(publishTrdIndicator) + sep;
			 s += "TradeReportType(856)=" + new String(tradeReportType) + sep;
			 s += "TrdMatchID(880)=" + new String(trdMatchID) + sep;
			if (FixUtils.isSet(trdRptStatus)) s += "TrdRptStatus(939)=" + new String(trdRptStatus) + sep;
			if (FixUtils.isSet(memo)) s += "Memo(5149)=" + new String(memo) + sep;
			 s += "SubMktID(5815)=" + new String(subMktID) + sep;
			if (FixUtils.isSet(contraOrderRestrictions)) s += "ContraOrderRestrictions(5817)=" + String.valueOf(contraOrderRestrictions) + sep;
			if (FixUtils.isSet(mICCode)) s += "MICCode(9292)=" + new String(mICCode) + sep;
			if (FixUtils.isSet(clearingPrice)) s += "ClearingPrice(9822)=" + String.valueOf(clearingPrice) + sep;
			if (FixUtils.isSet(overrideFlag)) s += "OverrideFlag(9854)=" + String.valueOf(overrideFlag) + sep;
			if (FixUtils.isSet(delayedDisseminationInst)) s += "DelayedDisseminationInst(9855)=" + String.valueOf(delayedDisseminationInst) + sep;
			if (FixUtils.isSet(contraTradePA)) s += "ContraTradePA(9862)=" + String.valueOf(contraTradePA) + sep;
			if (FixUtils.isSet(contraClearingAcct)) s += "ContraClearingAcct(9863)=" + new String(contraClearingAcct) + sep;

			s += "checkSum(10)=" + String.valueOf(checkSum) + sep;

		} catch(Exception e) {  };

		return s;
	}

	@Override
	public boolean equals(Object o) {
		if (! ( o instanceof FixEntryNotificationtoAllegedFirm)) return false;

			FixEntryNotificationtoAllegedFirm msg = (FixEntryNotificationtoAllegedFirm) o;

		if ( ! super.equals(msg) ) return false;

		if (!( avgPx==msg.avgPx)) return false;

		if (!( cumQty==msg.cumQty)) return false;

		if (!Utils.equals( currency, msg.currency)) return false;

		if (!Utils.equals( execID, msg.execID)) return false;

		if (!( execTransType==msg.execTransType)) return false;

		if (!Utils.equals( orderID, msg.orderID)) return false;

		if (!( ordStatus==msg.ordStatus)) return false;

		if (!Utils.equals( securityID, msg.securityID)) return false;

		if (!( side==msg.side)) return false;

		if (!Utils.equals( symbol, msg.symbol)) return false;

		if (!Utils.equals( text, msg.text)) return false;

		if (!( processCode==msg.processCode)) return false;

		if (!Utils.equals( securityDesc, msg.securityDesc)) return false;

		if (!Utils.equals( clientID, msg.clientID)) return false;

		if (!( execType==msg.execType)) return false;

		if (!( leavesQty==msg.leavesQty)) return false;

		if (!( noContraBrokers==msg.noContraBrokers)) return false;

		if (!Utils.equals( contraBroker, msg.contraBroker)) return false;

		if (!( priceType==msg.priceType)) return false;

		if (!Utils.equals( transBkdTime, msg.transBkdTime)) return false;

		if (!Utils.equals( tradeReportID, msg.tradeReportID)) return false;

		if (!Utils.equals( clearingInstruction, msg.clearingInstruction)) return false;

		if (!Utils.equals( reversalIndicator, msg.reversalIndicator)) return false;

		if (!Utils.equals( tradeType, msg.tradeType)) return false;

		if (!Utils.equals( publishTrdIndicator, msg.publishTrdIndicator)) return false;

		if (!Utils.equals( tradeReportType, msg.tradeReportType)) return false;

		if (!Utils.equals( trdMatchID, msg.trdMatchID)) return false;

		if (!Utils.equals( trdRptStatus, msg.trdRptStatus)) return false;

		if (!Utils.equals( memo, msg.memo)) return false;

		if (!Utils.equals( subMktID, msg.subMktID)) return false;

		if (!( contraOrderRestrictions==msg.contraOrderRestrictions)) return false;

		if (!Utils.equals( mICCode, msg.mICCode)) return false;

		if (!( clearingPrice==msg.clearingPrice)) return false;

		if (!( overrideFlag==msg.overrideFlag)) return false;

		if (!( delayedDisseminationInst==msg.delayedDisseminationInst)) return false;

		if (!( contraTradePA==msg.contraTradePA)) return false;

		if (!Utils.equals( contraClearingAcct, msg.contraClearingAcct)) return false;

		return true;
	}
}
