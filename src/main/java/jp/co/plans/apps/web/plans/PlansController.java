package jp.co.plans.apps.web.plans;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.plans.apps.web.query.InsertPlansQuery;
import jp.co.plans.apps.web.resource.InsertPlansResource;

/**
 * コンテンツの追加更新削除を行う。
 * @author kotarominamiyama
 *
 */
@RestController
public class PlansController {

	/**
	 * コンテンツ作成を行う。
	 * @param request
	 * @param query
	 * @param bindingResult
	 * @return
	 */
	@RequestMapping(value = "/insert/plans/", method = { RequestMethod.POST })
	public ResponseEntity<InsertPlansResource> insert(HttpServletRequest request,
			@RequestBody @Validated InsertPlansQuery query,
			BindingResult bindingResult) {

		InsertPlansResource resource = new InsertPlansResource();

		return ResponseEntity.ok().body(resource);
	}
}
