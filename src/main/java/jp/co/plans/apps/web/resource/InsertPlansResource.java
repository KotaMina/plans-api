package jp.co.plans.apps.web.resource;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Plans作成結果クラス。
 * @author kotarominamiyama
 *
 */
@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InsertPlansResource extends BaseResource implements Serializable {

	private static final long serialVersionUID = 1L;

	private String plansId;
}
